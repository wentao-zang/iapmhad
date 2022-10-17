package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LhLocadis2Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocadis2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LhLocadis3Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocadis3Entity;
import com.iapmhad.yhpostureadjust.service.LhLocadis3Service;


@Service("lhLocadis3Service")
public class LhLocadis3ServiceImpl extends ServiceImpl<LhLocadis3Dao, LhLocadis3Entity> implements LhLocadis3Service {

    @Autowired
    LhLocadis3Dao lhLocadis3Dao;

    @Override
    public List<LhLocadis3Entity> getLi(int id) {
        List<LhLocadis3Entity> last = lhLocadis3Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LhLocadis3Entity> page = this.page(
                new Query<LhLocadis3Entity>().getPage(params),
                new QueryWrapper<LhLocadis3Entity>()
        );

        return new PageUtils(page);
    }

}