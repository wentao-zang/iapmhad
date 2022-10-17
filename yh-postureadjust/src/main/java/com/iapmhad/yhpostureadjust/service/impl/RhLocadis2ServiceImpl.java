package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RhLocadis1Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocadis1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RhLocadis2Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocadis2Entity;
import com.iapmhad.yhpostureadjust.service.RhLocadis2Service;


@Service("rhLocadis2Service")
public class RhLocadis2ServiceImpl extends ServiceImpl<RhLocadis2Dao, RhLocadis2Entity> implements RhLocadis2Service {

    @Autowired
    RhLocadis2Dao rhLocadis2Dao;

    @Override
    public List<RhLocadis2Entity> getLi(int id) {
        List<RhLocadis2Entity> last = rhLocadis2Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RhLocadis2Entity> page = this.page(
                new Query<RhLocadis2Entity>().getPage(params),
                new QueryWrapper<RhLocadis2Entity>()
        );

        return new PageUtils(page);
    }

}