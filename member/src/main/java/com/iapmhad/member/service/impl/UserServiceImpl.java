package com.iapmhad.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.member.dao.UserDao;
import com.iapmhad.member.entity.UserEntity;
import com.iapmhad.member.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    UserDao userDao;

    @Override
    public UserEntity verify(String username) {
        UserEntity user =userDao.verify(username);
        return user;
    }

    @Override
    public void saveU(String username, String password, String privilegeId) {
        userDao.saveU(username,password,privilegeId);
    }

}