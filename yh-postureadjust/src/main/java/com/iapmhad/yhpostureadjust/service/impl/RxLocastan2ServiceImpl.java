package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RxLocastan1Dao;
import com.iapmhad.yhpostureadjust.entity.RxLocastan1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RxLocastan2Dao;
import com.iapmhad.yhpostureadjust.entity.RxLocastan2Entity;
import com.iapmhad.yhpostureadjust.service.RxLocastan2Service;


@Service("rxLocastan2Service")
public class RxLocastan2ServiceImpl extends ServiceImpl<RxLocastan2Dao, RxLocastan2Entity> implements RxLocastan2Service {

    @Autowired
    RxLocastan2Dao rxLocastan2Dao;

    @Override
    public List<RxLocastan2Entity> getLi(int id) {
        List<RxLocastan2Entity> last = rxLocastan2Dao.getLi(id);
        return last;
    }
    
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RxLocastan2Entity> page = this.page(
                new Query<RxLocastan2Entity>().getPage(params),
                new QueryWrapper<RxLocastan2Entity>()
        );

        return new PageUtils(page);
    }

}