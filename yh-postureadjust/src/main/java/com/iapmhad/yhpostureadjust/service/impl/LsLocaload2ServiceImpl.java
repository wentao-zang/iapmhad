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

import com.iapmhad.yhpostureadjust.dao.LsLocaload2Dao;
import com.iapmhad.yhpostureadjust.entity.LsLocaload2Entity;
import com.iapmhad.yhpostureadjust.service.LsLocaload2Service;


@Service("lsLocaload2Service")
public class LsLocaload2ServiceImpl extends ServiceImpl<LsLocaload2Dao, LsLocaload2Entity> implements LsLocaload2Service {

    @Autowired
    LsLocaload2Dao lsLocaload2Dao;

    @Override
    public List<LsLocaload2Entity> getLi(int id) {
        List<LsLocaload2Entity> last = lsLocaload2Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LsLocaload2Entity> page = this.page(
                new Query<LsLocaload2Entity>().getPage(params),
                new QueryWrapper<LsLocaload2Entity>()
        );

        return new PageUtils(page);
    }

}