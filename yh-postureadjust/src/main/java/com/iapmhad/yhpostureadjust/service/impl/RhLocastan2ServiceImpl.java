package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RhLocastan1Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocastan1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RhLocastan2Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocastan2Entity;
import com.iapmhad.yhpostureadjust.service.RhLocastan2Service;


@Service("rhLocastan2Service")
public class RhLocastan2ServiceImpl extends ServiceImpl<RhLocastan2Dao, RhLocastan2Entity> implements RhLocastan2Service {

    @Autowired
    RhLocastan2Dao rhLocastan2Dao;

    @Override
    public List<RhLocastan2Entity> getLi(int id) {
        List<RhLocastan2Entity> last = rhLocastan2Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RhLocastan2Entity> page = this.page(
                new Query<RhLocastan2Entity>().getPage(params),
                new QueryWrapper<RhLocastan2Entity>()
        );

        return new PageUtils(page);
    }

}