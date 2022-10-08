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

import com.iapmhad.hdymzkjqrxt.dao.HoleAccuracyDao;
import com.iapmhad.hdymzkjqrxt.entity.HoleAccuracyEntity;
import com.iapmhad.hdymzkjqrxt.service.HoleAccuracyService;


@Service("holeAccuracyService")
public class HoleAccuracyServiceImpl extends ServiceImpl<HoleAccuracyDao, HoleAccuracyEntity> implements HoleAccuracyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HoleAccuracyEntity> page = this.page(
                new Query<HoleAccuracyEntity>().getPage(params),
                new QueryWrapper<HoleAccuracyEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    HoleAccuracyDao HoleAccuracyDao;

    @Override
    public List<HoleAccuracyEntity> getLi(int id) {
        List<HoleAccuracyEntity> li = HoleAccuracyDao.getLi(id);
        return li;
    }
    @Override
    public HoleAccuracyEntity getLast() {
        HoleAccuracyEntity last=HoleAccuracyDao.getLast();
        return last;
    }

}