package com.LuckyBai.Bicycle.Mapper;

import com.LuckyBai.Bicycle.Entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ASUS
* @description 针对表【users】的数据库操作Mapper
* @createDate 2022-09-24 11:25:21
* @Entity generator.domain.Users
*/
@Mapper
public interface UsersMapper extends BaseMapper<Users> {


}
