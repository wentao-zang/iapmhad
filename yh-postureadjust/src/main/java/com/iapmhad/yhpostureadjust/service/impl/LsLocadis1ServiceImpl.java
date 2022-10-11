package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LsLocadis1Dao;
import com.iapmhad.yhpostureadjust.entity.LsLocadis1Entity;
import com.iapmhad.yhpostureadjust.service.LsLocadis1Service;


@Service("lsLocadis1Service")
public class LsLocadis1ServiceImpl extends ServiceImpl<LsLocadis1Dao, LsLocadis1Entity> implements LsLocadis1Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LsLocadis1Entity> page = this.page(
                new Query<LsLocadis1Entity>().getPage(params),
                new QueryWrapper<LsLocadis1Entity>()
        );

        return new PageUtils(page);
    }

}