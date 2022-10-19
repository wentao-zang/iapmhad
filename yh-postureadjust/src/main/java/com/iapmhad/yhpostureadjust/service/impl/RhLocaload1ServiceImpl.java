package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LhLocaload3Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocaload3Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RhLocaload1Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocaload1Entity;
import com.iapmhad.yhpostureadjust.service.RhLocaload1Service;


@Service("rhLocaload1Service")
public class RhLocaload1ServiceImpl extends ServiceImpl<RhLocaload1Dao, RhLocaload1Entity> implements RhLocaload1Service {

    @Autowired
    RhLocaload1Dao rhLocaload1Dao;

    @Override
    public List<RhLocaload1Entity> getLi(int id) {
        List<RhLocaload1Entity> last = rhLocaload1Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RhLocaload1Entity> page = this.page(
                new Query<RhLocaload1Entity>().getPage(params),
                new QueryWrapper<RhLocaload1Entity>()
        );

        return new PageUtils(page);
    }

}