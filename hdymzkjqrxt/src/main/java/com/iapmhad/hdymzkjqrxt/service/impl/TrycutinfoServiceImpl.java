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

import com.iapmhad.hdymzkjqrxt.dao.TrycutinfoDao;
import com.iapmhad.hdymzkjqrxt.entity.TrycutinfoEntity;
import com.iapmhad.hdymzkjqrxt.service.TrycutinfoService;


@Service("trycutinfoService")
public class TrycutinfoServiceImpl extends ServiceImpl<TrycutinfoDao, TrycutinfoEntity> implements TrycutinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TrycutinfoEntity> page = this.page(
                new Query<TrycutinfoEntity>().getPage(params),
                new QueryWrapper<TrycutinfoEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    TrycutinfoDao TrycutinfoDao;

    @Override
    public List<TrycutinfoEntity> getLi(int id) {
        List<TrycutinfoEntity> li = TrycutinfoDao.getLi(id);
        return li;
    }
    @Override
    public TrycutinfoEntity getLast() {
        TrycutinfoEntity last=TrycutinfoDao.getLast();
        return last;
    }

}