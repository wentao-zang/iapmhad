package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RxLocastan2Dao;
import com.iapmhad.yhpostureadjust.entity.RxLocastan2Entity;
import com.iapmhad.yhpostureadjust.service.RxLocastan2Service;


@Service("rxLocastan2Service")
public class RxLocastan2ServiceImpl extends ServiceImpl<RxLocastan2Dao, RxLocastan2Entity> implements RxLocastan2Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RxLocastan2Entity> page = this.page(
                new Query<RxLocastan2Entity>().getPage(params),
                new QueryWrapper<RxLocastan2Entity>()
        );

        return new PageUtils(page);
    }

}