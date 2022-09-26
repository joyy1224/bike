package com.LuckyBai.Bicycle.Controller;

import com.LuckyBai.Bicycle.Common.BaseContext;
import com.LuckyBai.Bicycle.Common.Result;
import com.LuckyBai.Bicycle.Entity.Users;
import com.LuckyBai.Bicycle.Service.UsersService;
import com.LuckyBai.Bicycle.dto.UserCodeDto;
import com.LuckyBai.Bicycle.utils.PhoneUtils;
import com.LuckyBai.Bicycle.utils.ValidateCodeUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import org.apache.commons.lang.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * redis 验证码key
     */
    public static final String PHONE_KEY= "code::";

    @Resource
    @Autowired
    private UsersService usersService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/login")
    public Result<Users> login(@RequestBody Users users) {

        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Users::getPhone, users.getPhone());
        Users em = usersService.getOne(queryWrapper);

        if (em == null) {
            return Result.error("登录失败");
        }
        String md5Password = getMD5Password(users.getPassword(), em.getSalt());
        if (!md5Password.equals(em.getPassword())) {
            return Result.error("登录失败mima");
        }
        BaseContext.setCurrentId(Long.valueOf(users.getPhone()));
        return Result.success(em);
    }

    private String getMD5Password(String password, String salt){
        for (int i = 1;i < 3; i++){
            password = DigestUtils.md5DigestAsHex((salt+password).getBytes()).toUpperCase();
        }
        return password;
    }

    @PostMapping("/sendMsg")
    public Result<String> sendMsg(@RequestBody Users users,HttpSession session){
        //获取手机号
        String phone = String.valueOf(users.getPhone());
        //验证手机格式
        if (!PhoneUtils.isMobile(phone)){
             return Result.error("手机格式错误");
        }
        if(StringUtils.isNotEmpty(phone)){
            //判断redis中是否已经发送过验证码
            String key = PHONE_KEY+phone;
            Object o = new Object();
            o = redisTemplate.opsForValue().get(key);
            if (o != null){
                Long timeto = redisTemplate.opsForValue().getOperations().getExpire(key);
                return Result.error("请"+timeto+"秒后重试");
            }
            //生成随机的4位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            //阿里云短信服务发送短信
//            SendSms.sendMsg(phone,code);
//            将手机号存在session中
            session.setAttribute("phone",phone);
            System.err.println("短信验证码"+code);
            redisTemplate.opsForValue().set(key, code, 60, TimeUnit.SECONDS);
            return Result.success("手机验证码发送成功！");
        }
        return Result.error("短信发送失败！");
    }

    @PostMapping("/msglogin")
    public Result<String> Msglogin(@RequestBody UserCodeDto users){
        //获取手机号
        String phone = users.getPhone();
        String code = users.getCode();
        //验证手机格式
        if (!PhoneUtils.isMobile(phone)){
            return Result.error("手机格式错误");
        }
        ValueOperations ops = redisTemplate.opsForValue();
        String key = PHONE_KEY + phone;
        Object codeValue = ops.get(key);
        if (codeValue == null){
            return Result.error("验证码过期");
        }
        if (!Objects.equals(codeValue.toString(),code)){
            return Result.error("验证码错误");
        }
        BaseContext.setCurrentId(Long.parseLong(users.getPhone()));
        redisTemplate.delete(key);
        return Result.success("成功");
    }

    @PostMapping("/register")
    public Result<Users> register(@RequestBody UserCodeDto users) {
        log.info("phone:{}", users.getPhone());
        log.info("password:{}", users.getPassword());
        String phone = users.getPhone();
        String password = users.getPassword();
        String code = users.getCode();
        if (StringUtils.isEmpty(phone)) {
            return Result.error("手机号不允许为空");
        }
        if (StringUtils.isEmpty(password)) {
            return Result.error("密码不允许为空");
        }
        if (StringUtils.isEmpty(code)){
            return Result.error("验证码不能为空");
        }
        String key = PHONE_KEY+phone;
        Object o = new Object();
        o = redisTemplate.opsForValue().get(key);
        if (o == null){
            return Result.error("验证码失效");
        }
        String s = o.toString();
        if (!Objects.equals(s,code)){
            return Result.error("验证码错误");
        }
        redisTemplate.delete(key);
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Users::getPhone, users.getPhone());
        Users em = usersService.getOne(queryWrapper);
        if (em == null) {
            String salt = UUID.randomUUID().toString().toUpperCase();
            users.setSalt(salt);
            String md5Password = getMD5Password(password, salt);
            users.setPassword(md5Password);
            usersService.save(users);
            log.info("Users:{}", users);
            return Result.success(users);
        } else {
            return Result.error("注册失败，账户已经存在");
        }
    }

    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("Users");
        System.err.println("结束！");
        return Result.success("退出成功");
    }
}