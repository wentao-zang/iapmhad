package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LhLocaload2Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocaload2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LhLocaload3Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocaload3Entity;
import com.iapmhad.yhpostureadjust.service.LhLocaload3Service;


@Service("lhLocaload3Service")
public class LhLocaload3ServiceImpl extends ServiceImpl<LhLocaload3Dao, LhLocaload3Entity> implements LhLocaload3Service {

    @Autowired
    LhLocaload3Dao lhLocaload3Dao;

    @Override
    public List<LhLocaload3Entity> getLi(int id) {
        List<LhLocaload3Entity> last = lhLocaload3Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LhLocaload3Entity> page = this.page(
                new Query<LhLocaload3Entity>().getPage(params),
                new QueryWrapper<LhLocaload3Entity>()
        );

        return new PageUtils(page);
    }

}