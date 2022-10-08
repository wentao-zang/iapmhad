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

import com.iapmhad.hdymzkjqrxt.dao.HoleProcessDao;
import com.iapmhad.hdymzkjqrxt.entity.HoleProcessEntity;
import com.iapmhad.hdymzkjqrxt.service.HoleProcessService;


@Service("holeProcessService")
public class HoleProcessServiceImpl extends ServiceImpl<HoleProcessDao, HoleProcessEntity> implements HoleProcessService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HoleProcessEntity> page = this.page(
                new Query<HoleProcessEntity>().getPage(params),
                new QueryWrapper<HoleProcessEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    HoleProcessDao HoleProcessDao;

    @Override
    public List<HoleProcessEntity> getLi(int id) {
        List<HoleProcessEntity> li = HoleProcessDao.getLi(id);
        return li;
    }
    @Override
    public HoleProcessEntity getLast() {
        HoleProcessEntity last=HoleProcessDao.getLast();
        return last;
    }

}