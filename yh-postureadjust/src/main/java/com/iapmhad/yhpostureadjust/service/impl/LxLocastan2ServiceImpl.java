package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LxLocastan2Dao;
import com.iapmhad.yhpostureadjust.entity.LxLocastan2Entity;
import com.iapmhad.yhpostureadjust.service.LxLocastan2Service;


@Service("lxLocastan2Service")
public class LxLocastan2ServiceImpl extends ServiceImpl<LxLocastan2Dao, LxLocastan2Entity> implements LxLocastan2Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LxLocastan2Entity> page = this.page(
                new Query<LxLocastan2Entity>().getPage(params),
                new QueryWrapper<LxLocastan2Entity>()
        );

        return new PageUtils(page);
    }

}