package com.iapmhad.jydbjdj.service.impl;

import com.iapmhad.jydbjdj.dao.LwLocastanDao;
import com.iapmhad.jydbjdj.entity.LwLocastanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.jydbjdj.dao.RwLocadisDao;
import com.iapmhad.jydbjdj.entity.RwLocadisEntity;
import com.iapmhad.jydbjdj.service.RwLocadisService;


@Service("rwLocadisService")
public class RwLocadisServiceImpl extends ServiceImpl<RwLocadisDao, RwLocadisEntity> implements RwLocadisService {

    @Autowired
    RwLocadisDao rwLocadisDao;

    @Override
    public List<RwLocadisEntity> getLi(int id) {
        List<RwLocadisEntity> last = rwLocadisDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RwLocadisEntity> page = this.page(
                new Query<RwLocadisEntity>().getPage(params),
                new QueryWrapper<RwLocadisEntity>()
        );

        return new PageUtils(page);
    }

}