package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RsLocaload1Dao;
import com.iapmhad.yhpostureadjust.entity.RsLocaload1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RsLocaload2Dao;
import com.iapmhad.yhpostureadjust.entity.RsLocaload2Entity;
import com.iapmhad.yhpostureadjust.service.RsLocaload2Service;


@Service("rsLocaload2Service")
public class RsLocaload2ServiceImpl extends ServiceImpl<RsLocaload2Dao, RsLocaload2Entity> implements RsLocaload2Service {

    @Autowired
    RsLocaload2Dao rsLocaload2Dao;

    @Override
    public List<RsLocaload2Entity> getLi(int id) {
        List<RsLocaload2Entity> last = rsLocaload2Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RsLocaload2Entity> page = this.page(
                new Query<RsLocaload2Entity>().getPage(params),
                new QueryWrapper<RsLocaload2Entity>()
        );

        return new PageUtils(page);
    }

}