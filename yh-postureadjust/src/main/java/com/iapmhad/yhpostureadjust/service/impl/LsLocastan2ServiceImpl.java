package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LxLocastan2Dao;
import com.iapmhad.yhpostureadjust.entity.LsLocadis2Entity;
import com.iapmhad.yhpostureadjust.entity.LxLocastan2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LsLocastan2Dao;
import com.iapmhad.yhpostureadjust.entity.LsLocastan2Entity;
import com.iapmhad.yhpostureadjust.service.LsLocastan2Service;


@Service("lsLocastan2Service")
public class LsLocastan2ServiceImpl extends ServiceImpl<LsLocastan2Dao, LsLocastan2Entity> implements LsLocastan2Service {

    @Autowired
    LsLocastan2Dao lsLocastan2Dao;

    @Override
    public List<LsLocastan2Entity> getLi(int id) {
        List<LsLocastan2Entity> last = lsLocastan2Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LsLocastan2Entity> page = this.page(
                new Query<LsLocastan2Entity>().getPage(params),
                new QueryWrapper<LsLocastan2Entity>()
        );

        return new PageUtils(page);
    }

}