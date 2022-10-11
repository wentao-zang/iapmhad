package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LsLocastan2Dao;
import com.iapmhad.yhpostureadjust.entity.LsLocastan2Entity;
import com.iapmhad.yhpostureadjust.service.LsLocastan2Service;


@Service("lsLocastan2Service")
public class LsLocastan2ServiceImpl extends ServiceImpl<LsLocastan2Dao, LsLocastan2Entity> implements LsLocastan2Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LsLocastan2Entity> page = this.page(
                new Query<LsLocastan2Entity>().getPage(params),
                new QueryWrapper<LsLocastan2Entity>()
        );

        return new PageUtils(page);
    }

}