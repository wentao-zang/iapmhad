package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RhLocadis3Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocadis3Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RhLocastan1Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocastan1Entity;
import com.iapmhad.yhpostureadjust.service.RhLocastan1Service;


@Service("rhLocastan1Service")
public class RhLocastan1ServiceImpl extends ServiceImpl<RhLocastan1Dao, RhLocastan1Entity> implements RhLocastan1Service {

    @Autowired
    RhLocastan1Dao rhLocastan1Dao;

    @Override
    public List<RhLocastan1Entity> getLi(int id) {
        List<RhLocastan1Entity> last = rhLocastan1Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RhLocastan1Entity> page = this.page(
                new Query<RhLocastan1Entity>().getPage(params),
                new QueryWrapper<RhLocastan1Entity>()
        );

        return new PageUtils(page);
    }

}