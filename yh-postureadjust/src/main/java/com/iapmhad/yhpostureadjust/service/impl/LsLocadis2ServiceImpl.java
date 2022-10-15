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

import com.iapmhad.yhpostureadjust.dao.LsLocadis2Dao;
import com.iapmhad.yhpostureadjust.entity.LsLocadis2Entity;
import com.iapmhad.yhpostureadjust.service.LsLocadis2Service;


@Service("lsLocadis2Service")
public class LsLocadis2ServiceImpl extends ServiceImpl<LsLocadis2Dao, LsLocadis2Entity> implements LsLocadis2Service {

    @Autowired
    LsLocadis2Dao lsLocadis2Dao;

    @Override
    public List<LsLocadis2Entity> getLi(int id) {
        List<LsLocadis2Entity> last = lsLocadis2Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LsLocadis2Entity> page = this.page(
                new Query<LsLocadis2Entity>().getPage(params),
                new QueryWrapper<LsLocadis2Entity>()
        );

        return new PageUtils(page);
    }

}