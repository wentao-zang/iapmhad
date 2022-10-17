package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LhLocadis3Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocadis3Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LhLocastan1Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocastan1Entity;
import com.iapmhad.yhpostureadjust.service.LhLocastan1Service;


@Service("lhLocastan1Service")
public class LhLocastan1ServiceImpl extends ServiceImpl<LhLocastan1Dao, LhLocastan1Entity> implements LhLocastan1Service {

    @Autowired
    LhLocastan1Dao lhLocastan1Dao;

    @Override
    public List<LhLocastan1Entity> getLi(int id) {
        List<LhLocastan1Entity> last = lhLocastan1Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LhLocastan1Entity> page = this.page(
                new Query<LhLocastan1Entity>().getPage(params),
                new QueryWrapper<LhLocastan1Entity>()
        );

        return new PageUtils(page);
    }

}