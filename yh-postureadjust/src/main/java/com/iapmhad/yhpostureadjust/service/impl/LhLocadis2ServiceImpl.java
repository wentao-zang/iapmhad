package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LhLocadis1Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocadis1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LhLocadis2Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocadis2Entity;
import com.iapmhad.yhpostureadjust.service.LhLocadis2Service;


@Service("lhLocadis2Service")
public class LhLocadis2ServiceImpl extends ServiceImpl<LhLocadis2Dao, LhLocadis2Entity> implements LhLocadis2Service {

    @Autowired
    LhLocadis2Dao lhLocadis2Dao;

    @Override
    public List<LhLocadis2Entity> getLi(int id) {
        List<LhLocadis2Entity> last = lhLocadis2Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LhLocadis2Entity> page = this.page(
                new Query<LhLocadis2Entity>().getPage(params),
                new QueryWrapper<LhLocadis2Entity>()
        );

        return new PageUtils(page);
    }

}