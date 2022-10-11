package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LxLocadis2Dao;
import com.iapmhad.yhpostureadjust.entity.LxLocadis2Entity;
import com.iapmhad.yhpostureadjust.service.LxLocadis2Service;


@Service("lxLocadis2Service")
public class LxLocadis2ServiceImpl extends ServiceImpl<LxLocadis2Dao, LxLocadis2Entity> implements LxLocadis2Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LxLocadis2Entity> page = this.page(
                new Query<LxLocadis2Entity>().getPage(params),
                new QueryWrapper<LxLocadis2Entity>()
        );

        return new PageUtils(page);
    }

}