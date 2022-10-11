package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RxLocaload1Dao;
import com.iapmhad.yhpostureadjust.entity.RxLocaload1Entity;
import com.iapmhad.yhpostureadjust.service.RxLocaload1Service;


@Service("rxLocaload1Service")
public class RxLocaload1ServiceImpl extends ServiceImpl<RxLocaload1Dao, RxLocaload1Entity> implements RxLocaload1Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RxLocaload1Entity> page = this.page(
                new Query<RxLocaload1Entity>().getPage(params),
                new QueryWrapper<RxLocaload1Entity>()
        );

        return new PageUtils(page);
    }

}