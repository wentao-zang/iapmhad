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

import com.iapmhad.hdymzkjqrxt.dao.GyProcessDao;
import com.iapmhad.hdymzkjqrxt.entity.GyProcessEntity;
import com.iapmhad.hdymzkjqrxt.service.GyProcessService;


@Service("gyProcessService")
public class GyProcessServiceImpl extends ServiceImpl<GyProcessDao, GyProcessEntity> implements GyProcessService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyProcessEntity> page = this.page(
                new Query<GyProcessEntity>().getPage(params),
                new QueryWrapper<GyProcessEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    GyProcessDao GyProcessDao;

    @Override
    public List<GyProcessEntity> getLi(int id) {
        List<GyProcessEntity> li = GyProcessDao.getLi(id);
        return li;
    }
    @Override
    public GyProcessEntity getLast() {
        GyProcessEntity last=GyProcessDao.getLast();
        return last;
    }

}