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

import com.iapmhad.hdymzkjqrxt.dao.FxclzzSpecificationDao;
import com.iapmhad.hdymzkjqrxt.entity.FxclzzSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.FxclzzSpecificationService;


@Service("fxclzzSpecificationService")
public class FxclzzSpecificationServiceImpl extends ServiceImpl<FxclzzSpecificationDao, FxclzzSpecificationEntity> implements FxclzzSpecificationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FxclzzSpecificationEntity> page = this.page(
                new Query<FxclzzSpecificationEntity>().getPage(params),
                new QueryWrapper<FxclzzSpecificationEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    FxclzzSpecificationDao FxclzzSpecificationDao;

    @Override
    public List<FxclzzSpecificationEntity> getLi(int id) {
        List<FxclzzSpecificationEntity> li = FxclzzSpecificationDao.getLi(id);
        return li;
    }
    @Override
    public FxclzzSpecificationEntity getLast() {
        FxclzzSpecificationEntity last=FxclzzSpecificationDao.getLast();
        return last;
    }

}