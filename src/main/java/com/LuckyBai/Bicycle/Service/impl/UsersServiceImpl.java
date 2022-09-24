package com.LuckyBai.Bicycle.Service.impl;

import com.LuckyBai.Bicycle.Entity.Users;
import com.LuckyBai.Bicycle.Mapper.UsersMapper;
import com.LuckyBai.Bicycle.Service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author ASUS
* @description 针对表【users】的数据库操作Service实现
* @createDate 2022-09-24 11:25:21
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
}
