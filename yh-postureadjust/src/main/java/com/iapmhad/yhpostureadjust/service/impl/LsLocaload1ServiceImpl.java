package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LsLocaload1Dao;
import com.iapmhad.yhpostureadjust.entity.LsLocaload1Entity;
import com.iapmhad.yhpostureadjust.service.LsLocaload1Service;


@Service("lsLocaload1Service")
public class LsLocaload1ServiceImpl extends ServiceImpl<LsLocaload1Dao, LsLocaload1Entity> implements LsLocaload1Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LsLocaload1Entity> page = this.page(
                new Query<LsLocaload1Entity>().getPage(params),
                new QueryWrapper<LsLocaload1Entity>()
        );

        return new PageUtils(page);
    }

}