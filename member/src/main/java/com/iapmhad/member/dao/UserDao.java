package com.iapmhad.member.dao;

import com.iapmhad.member.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 
 * 
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-03-09 13:18:45
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
    public  UserEntity verify(String username);
    public  void saveU(String username,String password,String privilegeId);


	
}
