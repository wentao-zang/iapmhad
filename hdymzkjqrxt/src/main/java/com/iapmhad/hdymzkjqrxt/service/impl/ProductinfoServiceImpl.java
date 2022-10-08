package com.iapmhad.hdymzkjqrxt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.hdymzkjqrxt.dao.ProductinfoDao;
import com.iapmhad.hdymzkjqrxt.entity.ProductinfoEntity;
import com.iapmhad.hdymzkjqrxt.service.ProductinfoService;


@Service("productinfoService")
public class ProductinfoServiceImpl extends ServiceImpl<ProductinfoDao, ProductinfoEntity> implements ProductinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductinfoEntity> page = this.page(
                new Query<ProductinfoEntity>().getPage(params),
                new QueryWrapper<ProductinfoEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    ProductinfoDao ProductinfoDao;

    @Override
    public List<ProductinfoEntity> getLi(int id) {
        List<ProductinfoEntity> li = ProductinfoDao.getLi(id);
        return li;
    }
    @Override
    public ProductinfoEntity getLast() {
        ProductinfoEntity last=ProductinfoDao.getLast();
        return last;
    }

}