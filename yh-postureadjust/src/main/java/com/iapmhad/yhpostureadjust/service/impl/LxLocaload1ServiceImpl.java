package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LxLocaload1Dao;
import com.iapmhad.yhpostureadjust.entity.LxLocaload1Entity;
import com.iapmhad.yhpostureadjust.service.LxLocaload1Service;


@Service("lxLocaload1Service")
public class LxLocaload1ServiceImpl extends ServiceImpl<LxLocaload1Dao, LxLocaload1Entity> implements LxLocaload1Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LxLocaload1Entity> page = this.page(
                new Query<LxLocaload1Entity>().getPage(params),
                new QueryWrapper<LxLocaload1Entity>()
        );

        return new PageUtils(page);
    }

}