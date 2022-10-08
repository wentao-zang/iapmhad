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

import com.iapmhad.hdymzkjqrxt.dao.SjclzzSpecificationDao;
import com.iapmhad.hdymzkjqrxt.entity.SjclzzSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.SjclzzSpecificationService;


@Service("sjclzzSpecificationService")
public class SjclzzSpecificationServiceImpl extends ServiceImpl<SjclzzSpecificationDao, SjclzzSpecificationEntity> implements SjclzzSpecificationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SjclzzSpecificationEntity> page = this.page(
                new Query<SjclzzSpecificationEntity>().getPage(params),
                new QueryWrapper<SjclzzSpecificationEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    SjclzzSpecificationDao SjclzzSpecificationDao;

    @Override
    public List<SjclzzSpecificationEntity> getLi(int id) {
        List<SjclzzSpecificationEntity> li = SjclzzSpecificationDao.getLi(id);
        return li;
    }
    @Override
    public SjclzzSpecificationEntity getLast() {
        SjclzzSpecificationEntity last=SjclzzSpecificationDao.getLast();
        return last;
    }

}