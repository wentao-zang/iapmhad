package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RhfLocastanDao;
import com.iapmhad.yhpostureadjust.entity.RhfLocastanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RhLocadis1Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocadis1Entity;
import com.iapmhad.yhpostureadjust.service.RhLocadis1Service;


@Service("rhLocadis1Service")
public class RhLocadis1ServiceImpl extends ServiceImpl<RhLocadis1Dao, RhLocadis1Entity> implements RhLocadis1Service {

    @Autowired
    RhLocadis1Dao rhLocadis1Dao;

    @Override
    public List<RhLocadis1Entity> getLi(int id) {
        List<RhLocadis1Entity> last = rhLocadis1Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RhLocadis1Entity> page = this.page(
                new Query<RhLocadis1Entity>().getPage(params),
                new QueryWrapper<RhLocadis1Entity>()
        );

        return new PageUtils(page);
    }

}