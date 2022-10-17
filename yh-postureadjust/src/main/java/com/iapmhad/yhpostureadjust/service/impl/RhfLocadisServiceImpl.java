package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LhLocastan3Dao;
import com.iapmhad.yhpostureadjust.entity.LhLocastan3Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RhfLocadisDao;
import com.iapmhad.yhpostureadjust.entity.RhfLocadisEntity;
import com.iapmhad.yhpostureadjust.service.RhfLocadisService;


@Service("rhfLocadisService")
public class RhfLocadisServiceImpl extends ServiceImpl<RhfLocadisDao, RhfLocadisEntity> implements RhfLocadisService {

    @Autowired
    RhfLocadisDao rhfLocadisDao;

    @Override
    public List<RhfLocadisEntity> getLi(int id) {
        List<RhfLocadisEntity> last = rhfLocadisDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RhfLocadisEntity> page = this.page(
                new Query<RhfLocadisEntity>().getPage(params),
                new QueryWrapper<RhfLocadisEntity>()
        );

        return new PageUtils(page);
    }

}