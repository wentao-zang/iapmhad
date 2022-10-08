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

import com.iapmhad.hdymzkjqrxt.dao.FootpressinfoDao;
import com.iapmhad.hdymzkjqrxt.entity.FootpressinfoEntity;
import com.iapmhad.hdymzkjqrxt.service.FootpressinfoService;


@Service("footpressinfoService")
public class FootpressinfoServiceImpl extends ServiceImpl<FootpressinfoDao, FootpressinfoEntity> implements FootpressinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FootpressinfoEntity> page = this.page(
                new Query<FootpressinfoEntity>().getPage(params),
                new QueryWrapper<FootpressinfoEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    FootpressinfoDao FootpressinfoDao;

    @Override
    public List<FootpressinfoEntity> getLi(int id) {
        List<FootpressinfoEntity> li = FootpressinfoDao.getLi(id);
        return li;
    }
    @Override
    public FootpressinfoEntity getLast() {
        FootpressinfoEntity last=FootpressinfoDao.getLast();
        return last;
    }

}