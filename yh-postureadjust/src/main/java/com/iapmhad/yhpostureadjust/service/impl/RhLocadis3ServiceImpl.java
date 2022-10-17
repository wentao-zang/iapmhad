package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RhLocadis2Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocadis2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RhLocadis3Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocadis3Entity;
import com.iapmhad.yhpostureadjust.service.RhLocadis3Service;


@Service("rhLocadis3Service")
public class RhLocadis3ServiceImpl extends ServiceImpl<RhLocadis3Dao, RhLocadis3Entity> implements RhLocadis3Service {

    @Autowired
    RhLocadis3Dao rhLocadis3Dao;

    @Override
    public List<RhLocadis3Entity> getLi(int id) {
        List<RhLocadis3Entity> last = rhLocadis3Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RhLocadis3Entity> page = this.page(
                new Query<RhLocadis3Entity>().getPage(params),
                new QueryWrapper<RhLocadis3Entity>()
        );

        return new PageUtils(page);
    }

}