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

import com.iapmhad.hdymzkjqrxt.dao.PosinfoDao;
import com.iapmhad.hdymzkjqrxt.entity.PosinfoEntity;
import com.iapmhad.hdymzkjqrxt.service.PosinfoService;


@Service("posinfoService")
public class PosinfoServiceImpl extends ServiceImpl<PosinfoDao, PosinfoEntity> implements PosinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PosinfoEntity> page = this.page(
                new Query<PosinfoEntity>().getPage(params),
                new QueryWrapper<PosinfoEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    PosinfoDao PosinfoDao;

    @Override
    public List<PosinfoEntity> getLi(int id) {
        List<PosinfoEntity> li = PosinfoDao.getLi(id);
        return li;
    }
    @Override
    public PosinfoEntity getLast() {
        PosinfoEntity last=PosinfoDao.getLast();
        return last;
    }

}