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

import com.iapmhad.yhpostureadjust.dao.LsLocaload1Dao;
import com.iapmhad.yhpostureadjust.entity.LsLocaload1Entity;
import com.iapmhad.yhpostureadjust.service.LsLocaload1Service;


@Service("lsLocaload1Service")
public class LsLocaload1ServiceImpl extends ServiceImpl<LsLocaload1Dao, LsLocaload1Entity> implements LsLocaload1Service {

    @Autowired
    LsLocaload1Dao lsLocaload1Dao;

    @Override
    public List<LsLocaload1Entity> getLi(int id) {
        List<LsLocaload1Entity> last = lsLocaload1Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LsLocaload1Entity> page = this.page(
                new Query<LsLocaload1Entity>().getPage(params),
                new QueryWrapper<LsLocaload1Entity>()
        );

        return new PageUtils(page);
    }

}