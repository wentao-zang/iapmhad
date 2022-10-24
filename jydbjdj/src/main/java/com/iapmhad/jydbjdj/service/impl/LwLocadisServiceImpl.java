package com.iapmhad.jydbjdj.service.impl;

import com.iapmhad.jydbjdj.dao.JyLocastanDao;
import com.iapmhad.jydbjdj.entity.JyLocastanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.jydbjdj.dao.LwLocadisDao;
import com.iapmhad.jydbjdj.entity.LwLocadisEntity;
import com.iapmhad.jydbjdj.service.LwLocadisService;


@Service("lwLocadisService")
public class LwLocadisServiceImpl extends ServiceImpl<LwLocadisDao, LwLocadisEntity> implements LwLocadisService {

    @Autowired
    LwLocadisDao lwLocadisDao;

    @Override
    public List<LwLocadisEntity> getLi(int id) {
        List<LwLocadisEntity> last = lwLocadisDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LwLocadisEntity> page = this.page(
                new Query<LwLocadisEntity>().getPage(params),
                new QueryWrapper<LwLocadisEntity>()
        );

        return new PageUtils(page);
    }

}