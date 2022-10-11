package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RxLocadis1Dao;
import com.iapmhad.yhpostureadjust.entity.RxLocadis1Entity;
import com.iapmhad.yhpostureadjust.service.RxLocadis1Service;


@Service("rxLocadis1Service")
public class RxLocadis1ServiceImpl extends ServiceImpl<RxLocadis1Dao, RxLocadis1Entity> implements RxLocadis1Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RxLocadis1Entity> page = this.page(
                new Query<RxLocadis1Entity>().getPage(params),
                new QueryWrapper<RxLocadis1Entity>()
        );

        return new PageUtils(page);
    }

}