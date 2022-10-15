package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RxLocaload2Dao;
import com.iapmhad.yhpostureadjust.entity.RxLocaload2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RxLocastan1Dao;
import com.iapmhad.yhpostureadjust.entity.RxLocastan1Entity;
import com.iapmhad.yhpostureadjust.service.RxLocastan1Service;


@Service("rxLocastan1Service")
public class RxLocastan1ServiceImpl extends ServiceImpl<RxLocastan1Dao, RxLocastan1Entity> implements RxLocastan1Service {

    @Autowired
    RxLocastan1Dao rxLocastan1Dao;

    @Override
    public List<RxLocastan1Entity> getLi(int id) {
        List<RxLocastan1Entity> last = rxLocastan1Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RxLocastan1Entity> page = this.page(
                new Query<RxLocastan1Entity>().getPage(params),
                new QueryWrapper<RxLocastan1Entity>()
        );

        return new PageUtils(page);
    }

}