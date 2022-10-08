package com.iapmhad.hdymzkjqrxt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.hdymzkjqrxt.dao.CpProductDao;
import com.iapmhad.hdymzkjqrxt.entity.CpProductEntity;
import com.iapmhad.hdymzkjqrxt.service.CpProductService;


@Service("cpProductService")
public class CpProductServiceImpl extends ServiceImpl<CpProductDao, CpProductEntity> implements CpProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CpProductEntity> page = this.page(
                new Query<CpProductEntity>().getPage(params),
                new QueryWrapper<CpProductEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    CpProductDao CpProductDao;


    @Override
    public List<CpProductEntity> getLi(int id) {
        List<CpProductEntity> li = CpProductDao.getLi(id);
        return li;
    }
    @Override
    public CpProductEntity getLast() {
        CpProductEntity last=CpProductDao.getLast();
        return last;

    }

}