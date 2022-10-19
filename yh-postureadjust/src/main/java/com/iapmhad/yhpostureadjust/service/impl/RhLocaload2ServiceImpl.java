package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RhLocaload1Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocaload1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RhLocaload2Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocaload2Entity;
import com.iapmhad.yhpostureadjust.service.RhLocaload2Service;


@Service("rhLocaload2Service")
public class RhLocaload2ServiceImpl extends ServiceImpl<RhLocaload2Dao, RhLocaload2Entity> implements RhLocaload2Service {

    @Autowired
    RhLocaload2Dao rhLocaload2Dao;

    @Override
    public List<RhLocaload2Entity> getLi(int id) {
        List<RhLocaload2Entity> last = rhLocaload2Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RhLocaload2Entity> page = this.page(
                new Query<RhLocaload2Entity>().getPage(params),
                new QueryWrapper<RhLocaload2Entity>()
        );

        return new PageUtils(page);
    }

}