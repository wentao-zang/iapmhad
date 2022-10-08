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

import com.iapmhad.hdymzkjqrxt.dao.StatusinfoDao;
import com.iapmhad.hdymzkjqrxt.entity.StatusinfoEntity;
import com.iapmhad.hdymzkjqrxt.service.StatusinfoService;


@Service("statusinfoService")
public class StatusinfoServiceImpl extends ServiceImpl<StatusinfoDao, StatusinfoEntity> implements StatusinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StatusinfoEntity> page = this.page(
                new Query<StatusinfoEntity>().getPage(params),
                new QueryWrapper<StatusinfoEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    StatusinfoDao StatusinfoDao;

    @Override
    public List<StatusinfoEntity> getLi(int id) {
        List<StatusinfoEntity> li = StatusinfoDao.getLi(id);
        return li;
    }
    @Override
    public StatusinfoEntity getLast() {
        StatusinfoEntity last=StatusinfoDao.getLast();
        return last;
    }

}