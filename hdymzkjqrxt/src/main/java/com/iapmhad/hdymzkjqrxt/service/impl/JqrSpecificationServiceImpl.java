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

import com.iapmhad.hdymzkjqrxt.dao.JqrSpecificationDao;
import com.iapmhad.hdymzkjqrxt.entity.JqrSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.JqrSpecificationService;


@Service("jqrSpecificationService")
public class JqrSpecificationServiceImpl extends ServiceImpl<JqrSpecificationDao, JqrSpecificationEntity> implements JqrSpecificationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JqrSpecificationEntity> page = this.page(
                new Query<JqrSpecificationEntity>().getPage(params),
                new QueryWrapper<JqrSpecificationEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    JqrSpecificationDao JqrSpecificationDao;

    @Override
    public List<JqrSpecificationEntity> getLi(int id) {
        List<JqrSpecificationEntity> li = JqrSpecificationDao.getLi(id);
        return li;
    }
    @Override
    public JqrSpecificationEntity getLast() {
        JqrSpecificationEntity last=JqrSpecificationDao.getLast();
        return last;
    }

}