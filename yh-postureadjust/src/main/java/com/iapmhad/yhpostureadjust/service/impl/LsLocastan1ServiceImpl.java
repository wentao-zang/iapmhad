package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LsLocaload2Dao;
import com.iapmhad.yhpostureadjust.entity.LsLocaload2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LsLocastan1Dao;
import com.iapmhad.yhpostureadjust.entity.LsLocastan1Entity;
import com.iapmhad.yhpostureadjust.service.LsLocastan1Service;


@Service("lsLocastan1Service")
public class LsLocastan1ServiceImpl extends ServiceImpl<LsLocastan1Dao, LsLocastan1Entity> implements LsLocastan1Service {

    @Autowired
    LsLocastan1Dao lsLocastan1Dao;

    @Override
    public List<LsLocastan1Entity> getLi(int id) {
        List<LsLocastan1Entity> last = lsLocastan1Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LsLocastan1Entity> page = this.page(
                new Query<LsLocastan1Entity>().getPage(params),
                new QueryWrapper<LsLocastan1Entity>()
        );

        return new PageUtils(page);
    }

}