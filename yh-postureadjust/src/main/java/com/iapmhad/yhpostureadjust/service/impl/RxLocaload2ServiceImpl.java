package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RxLocaload1Dao;
import com.iapmhad.yhpostureadjust.entity.RxLocaload1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RxLocaload2Dao;
import com.iapmhad.yhpostureadjust.entity.RxLocaload2Entity;
import com.iapmhad.yhpostureadjust.service.RxLocaload2Service;


@Service("rxLocaload2Service")
public class RxLocaload2ServiceImpl extends ServiceImpl<RxLocaload2Dao, RxLocaload2Entity> implements RxLocaload2Service {

    @Autowired
    RxLocaload2Dao rxLocaload2Dao;

    @Override
    public List<RxLocaload2Entity> getLi(int id) {
        List<RxLocaload2Entity> last = rxLocaload2Dao.getLi(id);
        return last;
    }


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RxLocaload2Entity> page = this.page(
                new Query<RxLocaload2Entity>().getPage(params),
                new QueryWrapper<RxLocaload2Entity>()
        );

        return new PageUtils(page);
    }

}