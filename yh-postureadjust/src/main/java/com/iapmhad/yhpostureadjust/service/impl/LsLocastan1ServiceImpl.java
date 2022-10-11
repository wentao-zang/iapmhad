package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LsLocastan1Dao;
import com.iapmhad.yhpostureadjust.entity.LsLocastan1Entity;
import com.iapmhad.yhpostureadjust.service.LsLocastan1Service;


@Service("lsLocastan1Service")
public class LsLocastan1ServiceImpl extends ServiceImpl<LsLocastan1Dao, LsLocastan1Entity> implements LsLocastan1Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LsLocastan1Entity> page = this.page(
                new Query<LsLocastan1Entity>().getPage(params),
                new QueryWrapper<LsLocastan1Entity>()
        );

        return new PageUtils(page);
    }

}