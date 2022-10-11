package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RsLocaload2Dao;
import com.iapmhad.yhpostureadjust.entity.RsLocaload2Entity;
import com.iapmhad.yhpostureadjust.service.RsLocaload2Service;


@Service("rsLocaload2Service")
public class RsLocaload2ServiceImpl extends ServiceImpl<RsLocaload2Dao, RsLocaload2Entity> implements RsLocaload2Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RsLocaload2Entity> page = this.page(
                new Query<RsLocaload2Entity>().getPage(params),
                new QueryWrapper<RsLocaload2Entity>()
        );

        return new PageUtils(page);
    }

}