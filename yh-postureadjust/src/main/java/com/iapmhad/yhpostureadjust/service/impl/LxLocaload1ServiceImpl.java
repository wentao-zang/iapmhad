package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LxLocadis2Dao;
import com.iapmhad.yhpostureadjust.entity.LxLocadis2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LxLocaload1Dao;
import com.iapmhad.yhpostureadjust.entity.LxLocaload1Entity;
import com.iapmhad.yhpostureadjust.service.LxLocaload1Service;


@Service("lxLocaload1Service")
public class LxLocaload1ServiceImpl extends ServiceImpl<LxLocaload1Dao, LxLocaload1Entity> implements LxLocaload1Service {

    @Autowired
    LxLocaload1Dao lxLocaload1Dao;

    @Override
    public List<LxLocaload1Entity> getLi(int id) {
        List<LxLocaload1Entity> last = lxLocaload1Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LxLocaload1Entity> page = this.page(
                new Query<LxLocaload1Entity>().getPage(params),
                new QueryWrapper<LxLocaload1Entity>()
        );

        return new PageUtils(page);
    }

}