package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RxLocadis2Dao;
import com.iapmhad.yhpostureadjust.entity.RxLocadis2Entity;
import com.iapmhad.yhpostureadjust.service.RxLocadis2Service;


@Service("rxLocadis2Service")
public class RxLocadis2ServiceImpl extends ServiceImpl<RxLocadis2Dao, RxLocadis2Entity> implements RxLocadis2Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RxLocadis2Entity> page = this.page(
                new Query<RxLocadis2Entity>().getPage(params),
                new QueryWrapper<RxLocadis2Entity>()
        );

        return new PageUtils(page);
    }

}