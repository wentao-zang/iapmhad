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

import com.iapmhad.hdymzkjqrxt.dao.SpinfoDao;
import com.iapmhad.hdymzkjqrxt.entity.SpinfoEntity;
import com.iapmhad.hdymzkjqrxt.service.SpinfoService;


@Service("spinfoService")
public class SpinfoServiceImpl extends ServiceImpl<SpinfoDao, SpinfoEntity> implements SpinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpinfoEntity> page = this.page(
                new Query<SpinfoEntity>().getPage(params),
                new QueryWrapper<SpinfoEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    SpinfoDao SpinfoDao;

    @Override
    public List<SpinfoEntity> getLi(int id) {
        List<SpinfoEntity> li = SpinfoDao.getLi(id);
        return li;
    }
    @Override
    public SpinfoEntity getLast() {
        SpinfoEntity last=SpinfoDao.getLast();
        return last;
    }

}