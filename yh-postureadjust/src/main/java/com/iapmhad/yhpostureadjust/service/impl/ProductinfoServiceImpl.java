package com.iapmhad.yh_postureadjust.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yh_postureadjust.dao.ProductinfoDao;
import com.iapmhad.yh_postureadjust.entity.ProductinfoEntity;
import com.iapmhad.yh_postureadjust.service.ProductinfoService;


@Service("productinfoService")
public class ProductinfoServiceImpl extends ServiceImpl<ProductinfoDao, ProductinfoEntity> implements ProductinfoService {

    @Autowired
    ProductinfoDao productinfoDao;

    @Override
    public List<ProductinfoEntity> getLi(int id) {
        List<ProductinfoEntity> last = productinfoDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductinfoEntity> page = this.page(
                new Query<ProductinfoEntity>().getPage(params),
                new QueryWrapper<ProductinfoEntity>()
        );

        return new PageUtils(page);
    }

}