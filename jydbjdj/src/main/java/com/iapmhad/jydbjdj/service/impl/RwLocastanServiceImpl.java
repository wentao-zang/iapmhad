package com.iapmhad.jydbjdj.service.impl;

import com.iapmhad.jydbjdj.dao.RwLocaloadDao;
import com.iapmhad.jydbjdj.entity.RwLocaloadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.jydbjdj.dao.RwLocastanDao;
import com.iapmhad.jydbjdj.entity.RwLocastanEntity;
import com.iapmhad.jydbjdj.service.RwLocastanService;


@Service("rwLocastanService")
public class RwLocastanServiceImpl extends ServiceImpl<RwLocastanDao, RwLocastanEntity> implements RwLocastanService {

    @Autowired
    RwLocastanDao rwLocastanDao;

    @Override
    public List<RwLocastanEntity> getLi(int id) {
        List<RwLocastanEntity> last = rwLocastanDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RwLocastanEntity> page = this.page(
                new Query<RwLocastanEntity>().getPage(params),
                new QueryWrapper<RwLocastanEntity>()
        );

        return new PageUtils(page);
    }

}