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

import com.iapmhad.hdymzkjqrxt.dao.DkSpecificationDao;
import com.iapmhad.hdymzkjqrxt.entity.DkSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.DkSpecificationService;


@Service("dkSpecificationService")
public class DkSpecificationServiceImpl extends ServiceImpl<DkSpecificationDao, DkSpecificationEntity> implements DkSpecificationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DkSpecificationEntity> page = this.page(
                new Query<DkSpecificationEntity>().getPage(params),
                new QueryWrapper<DkSpecificationEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    DkSpecificationDao DkSpecificationDao;

    @Override
    public List<DkSpecificationEntity> getLi(int id) {
        List<DkSpecificationEntity> li = DkSpecificationDao.getLi(id);
        return li;
    }
    @Override
    public DkSpecificationEntity getLast() {
        DkSpecificationEntity last=DkSpecificationDao.getLast();
        return last;
    }

}