package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RhLocaload2Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocaload2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RhLocaload3Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocaload3Entity;
import com.iapmhad.yhpostureadjust.service.RhLocaload3Service;


@Service("rhLocaload3Service")
public class RhLocaload3ServiceImpl extends ServiceImpl<RhLocaload3Dao, RhLocaload3Entity> implements RhLocaload3Service {

    @Autowired
    RhLocaload3Dao rhLocaload3Dao;

    @Override
    public List<RhLocaload3Entity> getLi(int id) {
        List<RhLocaload3Entity> last = rhLocaload3Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RhLocaload3Entity> page = this.page(
                new Query<RhLocaload3Entity>().getPage(params),
                new QueryWrapper<RhLocaload3Entity>()
        );

        return new PageUtils(page);
    }

}