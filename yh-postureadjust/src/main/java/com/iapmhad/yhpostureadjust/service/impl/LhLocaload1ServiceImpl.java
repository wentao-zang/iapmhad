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

import com.iapmhad.yhpostureadjust.dao.LhLocaload1Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocaload1Entity;
import com.iapmhad.yhpostureadjust.service.LhLocaload1Service;


@Service("lhLocaload1Service")
public class LhLocaload1ServiceImpl extends ServiceImpl<LhLocaload1Dao, LhLocaload1Entity> implements LhLocaload1Service {

    @Autowired
    LhLocaload1Dao lhLocaload1Dao;

    @Override
    public List<LhLocaload1Entity> getLi(int id) {
        List<LhLocaload1Entity> last = lhLocaload1Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LhLocaload1Entity> page = this.page(
                new Query<LhLocaload1Entity>().getPage(params),
                new QueryWrapper<LhLocaload1Entity>()
        );

        return new PageUtils(page);
    }

}