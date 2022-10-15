package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LxLocaload1Dao;
import com.iapmhad.yhpostureadjust.entity.LxLocaload1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LxLocaload2Dao;
import com.iapmhad.yhpostureadjust.entity.LxLocaload2Entity;
import com.iapmhad.yhpostureadjust.service.LxLocaload2Service;


@Service("lxLocaload2Service")
public class LxLocaload2ServiceImpl extends ServiceImpl<LxLocaload2Dao, LxLocaload2Entity> implements LxLocaload2Service {

    @Autowired
    LxLocaload2Dao lxLocaload2Dao;

    @Override
    public List<LxLocaload2Entity> getLi(int id) {
        List<LxLocaload2Entity> last = lxLocaload2Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LxLocaload2Entity> page = this.page(
                new Query<LxLocaload2Entity>().getPage(params),
                new QueryWrapper<LxLocaload2Entity>()
        );

        return new PageUtils(page);
    }

}