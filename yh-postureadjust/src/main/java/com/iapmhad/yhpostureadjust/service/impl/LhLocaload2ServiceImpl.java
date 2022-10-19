package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LhLocaload1Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocaload1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LhLocaload2Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocaload2Entity;
import com.iapmhad.yhpostureadjust.service.LhLocaload2Service;


@Service("lhLocaload2Service")
public class LhLocaload2ServiceImpl extends ServiceImpl<LhLocaload2Dao, LhLocaload2Entity> implements LhLocaload2Service {

    @Autowired
    LhLocaload2Dao lhLocaload2Dao;

    @Override
    public List<LhLocaload2Entity> getLi(int id) {
        List<LhLocaload2Entity> last = lhLocaload2Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LhLocaload2Entity> page = this.page(
                new Query<LhLocaload2Entity>().getPage(params),
                new QueryWrapper<LhLocaload2Entity>()
        );

        return new PageUtils(page);
    }

}