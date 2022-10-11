package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RsLocastan2Dao;
import com.iapmhad.yhpostureadjust.entity.RsLocastan2Entity;
import com.iapmhad.yhpostureadjust.service.RsLocastan2Service;


@Service("rsLocastan2Service")
public class RsLocastan2ServiceImpl extends ServiceImpl<RsLocastan2Dao, RsLocastan2Entity> implements RsLocastan2Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RsLocastan2Entity> page = this.page(
                new Query<RsLocastan2Entity>().getPage(params),
                new QueryWrapper<RsLocastan2Entity>()
        );

        return new PageUtils(page);
    }

}