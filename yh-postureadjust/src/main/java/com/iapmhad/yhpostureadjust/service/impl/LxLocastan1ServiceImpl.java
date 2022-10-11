package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LxLocastan1Dao;
import com.iapmhad.yhpostureadjust.entity.LxLocastan1Entity;
import com.iapmhad.yhpostureadjust.service.LxLocastan1Service;


@Service("lxLocastan1Service")
public class LxLocastan1ServiceImpl extends ServiceImpl<LxLocastan1Dao, LxLocastan1Entity> implements LxLocastan1Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LxLocastan1Entity> page = this.page(
                new Query<LxLocastan1Entity>().getPage(params),
                new QueryWrapper<LxLocastan1Entity>()
        );

        return new PageUtils(page);
    }

}