package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RsLocastan1Dao;
import com.iapmhad.yhpostureadjust.entity.RsLocastan1Entity;
import com.iapmhad.yhpostureadjust.service.RsLocastan1Service;


@Service("rsLocastan1Service")
public class RsLocastan1ServiceImpl extends ServiceImpl<RsLocastan1Dao, RsLocastan1Entity> implements RsLocastan1Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RsLocastan1Entity> page = this.page(
                new Query<RsLocastan1Entity>().getPage(params),
                new QueryWrapper<RsLocastan1Entity>()
        );

        return new PageUtils(page);
    }

}