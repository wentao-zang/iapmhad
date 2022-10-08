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

import com.iapmhad.hdymzkjqrxt.dao.YjzzSpecificationDao;
import com.iapmhad.hdymzkjqrxt.entity.YjzzSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.YjzzSpecificationService;


@Service("yjzzSpecificationService")
public class YjzzSpecificationServiceImpl extends ServiceImpl<YjzzSpecificationDao, YjzzSpecificationEntity> implements YjzzSpecificationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<YjzzSpecificationEntity> page = this.page(
                new Query<YjzzSpecificationEntity>().getPage(params),
                new QueryWrapper<YjzzSpecificationEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    YjzzSpecificationDao YjzzSpecificationDao;

    @Override
    public List<YjzzSpecificationEntity> getLi(int id) {
        List<YjzzSpecificationEntity> li = YjzzSpecificationDao.getLi(id);
        return li;
    }
    @Override
    public YjzzSpecificationEntity getLast() {
        YjzzSpecificationEntity last=YjzzSpecificationDao.getLast();
        return last;
    }

}