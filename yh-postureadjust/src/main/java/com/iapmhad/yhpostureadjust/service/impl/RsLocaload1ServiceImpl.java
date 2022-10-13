package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.entity.LsLocadis1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RsLocaload1Dao;
import com.iapmhad.yhpostureadjust.entity.RsLocaload1Entity;
import com.iapmhad.yhpostureadjust.service.RsLocaload1Service;


@Service("rsLocaload1Service")
public class RsLocaload1ServiceImpl extends ServiceImpl<RsLocaload1Dao, RsLocaload1Entity> implements RsLocaload1Service {

    @Autowired
    RsLocaload1Dao rsLocaload1Dao;

    @Override
    public List<RsLocaload1Entity> getLi(int id) {
        List<RsLocaload1Entity> last = rsLocaload1Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RsLocaload1Entity> page = this.page(
                new Query<RsLocaload1Entity>().getPage(params),
                new QueryWrapper<RsLocaload1Entity>()
        );

        return new PageUtils(page);
    }

}