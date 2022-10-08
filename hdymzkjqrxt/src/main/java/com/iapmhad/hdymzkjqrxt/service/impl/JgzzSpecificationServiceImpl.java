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

import com.iapmhad.hdymzkjqrxt.dao.JgzzSpecificationDao;
import com.iapmhad.hdymzkjqrxt.entity.JgzzSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.JgzzSpecificationService;


@Service("jgzzSpecificationService")
public class JgzzSpecificationServiceImpl extends ServiceImpl<JgzzSpecificationDao, JgzzSpecificationEntity> implements JgzzSpecificationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JgzzSpecificationEntity> page = this.page(
                new Query<JgzzSpecificationEntity>().getPage(params),
                new QueryWrapper<JgzzSpecificationEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    JgzzSpecificationDao JgzzSpecificationDao;

    @Override
    public List<JgzzSpecificationEntity> getLi(int id) {
        List<JgzzSpecificationEntity> li = JgzzSpecificationDao.getLi(id);
        return li;
    }
    @Override
    public JgzzSpecificationEntity getLast() {
        JgzzSpecificationEntity last=JgzzSpecificationDao.getLast();
        return last;
    }

}