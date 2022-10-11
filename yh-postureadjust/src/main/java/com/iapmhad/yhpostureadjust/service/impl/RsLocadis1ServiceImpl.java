package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RsLocadis1Dao;
import com.iapmhad.yhpostureadjust.entity.RsLocadis1Entity;
import com.iapmhad.yhpostureadjust.service.RsLocadis1Service;


@Service("rsLocadis1Service")
public class RsLocadis1ServiceImpl extends ServiceImpl<RsLocadis1Dao, RsLocadis1Entity> implements RsLocadis1Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RsLocadis1Entity> page = this.page(
                new Query<RsLocadis1Entity>().getPage(params),
                new QueryWrapper<RsLocadis1Entity>()
        );

        return new PageUtils(page);
    }

}