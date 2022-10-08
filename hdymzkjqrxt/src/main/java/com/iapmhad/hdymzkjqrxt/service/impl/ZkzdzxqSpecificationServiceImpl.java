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

import com.iapmhad.hdymzkjqrxt.dao.ZkzdzxqSpecificationDao;
import com.iapmhad.hdymzkjqrxt.entity.ZkzdzxqSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.ZkzdzxqSpecificationService;


@Service("zkzdzxqSpecificationService")
public class ZkzdzxqSpecificationServiceImpl extends ServiceImpl<ZkzdzxqSpecificationDao, ZkzdzxqSpecificationEntity> implements ZkzdzxqSpecificationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ZkzdzxqSpecificationEntity> page = this.page(
                new Query<ZkzdzxqSpecificationEntity>().getPage(params),
                new QueryWrapper<ZkzdzxqSpecificationEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    ZkzdzxqSpecificationDao ZkzdzxqSpecificationDao;

    @Override
    public List<ZkzdzxqSpecificationEntity> getLi(int id) {
        List<ZkzdzxqSpecificationEntity> li = ZkzdzxqSpecificationDao.getLi(id);
        return li;
    }
    @Override
    public ZkzdzxqSpecificationEntity getLast() {
        ZkzdzxqSpecificationEntity last=ZkzdzxqSpecificationDao.getLast();
        return last;
    }

}