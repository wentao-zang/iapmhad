package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LhfLocastanDao;
import com.iapmhad.yhpostureadjust.entity.LhfLocastanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LhLocadis1Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocadis1Entity;
import com.iapmhad.yhpostureadjust.service.LhLocadis1Service;


@Service("lhLocadis1Service")
public class LhLocadis1ServiceImpl extends ServiceImpl<LhLocadis1Dao, LhLocadis1Entity> implements LhLocadis1Service {

    @Autowired
    LhLocadis1Dao lhLocadis1Dao;

    @Override
    public List<LhLocadis1Entity> getLi(int id) {
        List<LhLocadis1Entity> last = lhLocadis1Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LhLocadis1Entity> page = this.page(
                new Query<LhLocadis1Entity>().getPage(params),
                new QueryWrapper<LhLocadis1Entity>()
        );

        return new PageUtils(page);
    }

}