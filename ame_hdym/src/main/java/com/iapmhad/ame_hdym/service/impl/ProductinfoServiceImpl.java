package com.iapmhad.ame_hdym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.ProductinfoDao;
import com.iapmhad.ame_hdym.entity.ProductinfoEntity;
import com.iapmhad.ame_hdym.service.ProductinfoService;


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
    ProductinfoDao productinfoDao;

    @Override
    public List<ProductinfoEntity> getLi(int id) {
        List<ProductinfoEntity> last = productinfoDao.getLi(id);
        return last;
    }
}