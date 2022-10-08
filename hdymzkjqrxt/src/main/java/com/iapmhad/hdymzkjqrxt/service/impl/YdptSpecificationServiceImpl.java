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

import com.iapmhad.hdymzkjqrxt.dao.YdptSpecificationDao;
import com.iapmhad.hdymzkjqrxt.entity.YdptSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.YdptSpecificationService;


@Service("ydptSpecificationService")
public class YdptSpecificationServiceImpl extends ServiceImpl<YdptSpecificationDao, YdptSpecificationEntity> implements YdptSpecificationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<YdptSpecificationEntity> page = this.page(
                new Query<YdptSpecificationEntity>().getPage(params),
                new QueryWrapper<YdptSpecificationEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    YdptSpecificationDao YdptSpecificationDao;

    @Override
    public List<YdptSpecificationEntity> getLi(int id) {
        List<YdptSpecificationEntity> li = YdptSpecificationDao.getLi(id);
        return li;
    }
    @Override
    public YdptSpecificationEntity getLast() {
        YdptSpecificationEntity last=YdptSpecificationDao.getLast();
        return last;
    }

}