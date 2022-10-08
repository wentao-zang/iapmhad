package com.iapmhad.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.member.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-03-09 13:18:45
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    UserEntity verify(String username);
    void saveU(String username,String password,String privilegeId);
}

