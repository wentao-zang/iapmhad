package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LhLocastan1Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocastan1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LhLocastan2Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocastan2Entity;
import com.iapmhad.yhpostureadjust.service.LhLocastan2Service;


@Service("lhLocastan2Service")
public class LhLocastan2ServiceImpl extends ServiceImpl<LhLocastan2Dao, LhLocastan2Entity> implements LhLocastan2Service {

    @Autowired
    LhLocastan2Dao lhLocastan2Dao;

    @Override
    public List<LhLocastan2Entity> getLi(int id) {
        List<LhLocastan2Entity> last = lhLocastan2Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LhLocastan2Entity> page = this.page(
                new Query<LhLocastan2Entity>().getPage(params),
                new QueryWrapper<LhLocastan2Entity>()
        );

        return new PageUtils(page);
    }

}