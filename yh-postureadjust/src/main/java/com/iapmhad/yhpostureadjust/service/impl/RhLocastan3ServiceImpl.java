package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RhLocastan2Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocastan2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RhLocastan3Dao;
import com.iapmhad.yhpostureadjust.entity.RhLocastan3Entity;
import com.iapmhad.yhpostureadjust.service.RhLocastan3Service;


@Service("rhLocastan3Service")
public class RhLocastan3ServiceImpl extends ServiceImpl<RhLocastan3Dao, RhLocastan3Entity> implements RhLocastan3Service {

    @Autowired
    RhLocastan3Dao rhLocastan3Dao;

    @Override
    public List<RhLocastan3Entity> getLi(int id) {
        List<RhLocastan3Entity> last = rhLocastan3Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RhLocastan3Entity> page = this.page(
                new Query<RhLocastan3Entity>().getPage(params),
                new QueryWrapper<RhLocastan3Entity>()
        );

        return new PageUtils(page);
    }

}