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

import com.iapmhad.hdymzkjqrxt.dao.HdymjqrzkxtStructureDao;
import com.iapmhad.hdymzkjqrxt.entity.HdymjqrzkxtStructureEntity;
import com.iapmhad.hdymzkjqrxt.service.HdymjqrzkxtStructureService;


@Service("hdymjqrzkxtStructureService")
public class HdymjqrzkxtStructureServiceImpl extends ServiceImpl<HdymjqrzkxtStructureDao, HdymjqrzkxtStructureEntity> implements HdymjqrzkxtStructureService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HdymjqrzkxtStructureEntity> page = this.page(
                new Query<HdymjqrzkxtStructureEntity>().getPage(params),
                new QueryWrapper<HdymjqrzkxtStructureEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    HdymjqrzkxtStructureDao HdymjqrzkxtStructureDao;

    @Override
    public List<HdymjqrzkxtStructureEntity> getLi(int id) {
        List<HdymjqrzkxtStructureEntity> li = HdymjqrzkxtStructureDao.getLi(id);
        return li;
    }
    @Override
    public HdymjqrzkxtStructureEntity getLast() {
        HdymjqrzkxtStructureEntity last=HdymjqrzkxtStructureDao.getLast();
        return last;
    }

}