package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LhLocastan2Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocastan2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LhLocastan3Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocastan3Entity;
import com.iapmhad.yhpostureadjust.service.LhLocastan3Service;


@Service("lhLocastan3Service")
public class LhLocastan3ServiceImpl extends ServiceImpl<LhLocastan3Dao, LhLocastan3Entity> implements LhLocastan3Service {

    @Autowired
    LhLocastan3Dao lhLocastan3Dao;

    @Override
    public List<LhLocastan3Entity> getLi(int id) {
        List<LhLocastan3Entity> last = lhLocastan3Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LhLocastan3Entity> page = this.page(
                new Query<LhLocastan3Entity>().getPage(params),
                new QueryWrapper<LhLocastan3Entity>()
        );

        return new PageUtils(page);
    }

}