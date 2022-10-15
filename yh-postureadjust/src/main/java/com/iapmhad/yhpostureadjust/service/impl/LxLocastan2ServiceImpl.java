package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LxLocaload2Dao;
import com.iapmhad.yhpostureadjust.entity.LxLocaload2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LxLocastan2Dao;
import com.iapmhad.yhpostureadjust.entity.LxLocastan2Entity;
import com.iapmhad.yhpostureadjust.service.LxLocastan2Service;


@Service("lxLocastan2Service")
public class LxLocastan2ServiceImpl extends ServiceImpl<LxLocastan2Dao, LxLocastan2Entity> implements LxLocastan2Service {

    @Autowired
    LxLocastan2Dao lxLocastan2Dao;

    @Override
    public List<LxLocastan2Entity> getLi(int id) {
        List<LxLocastan2Entity> last = lxLocastan2Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LxLocastan2Entity> page = this.page(
                new Query<LxLocastan2Entity>().getPage(params),
                new QueryWrapper<LxLocastan2Entity>()
        );

        return new PageUtils(page);
    }

}