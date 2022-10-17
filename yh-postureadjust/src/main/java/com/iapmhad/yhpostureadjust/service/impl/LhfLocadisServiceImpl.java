package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LsLocadis1Dao;
import com.iapmhad.yhpostureadjust.entity.LsLocadis1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LhfLocadisDao;
import com.iapmhad.yhpostureadjust.entity.LhfLocadisEntity;
import com.iapmhad.yhpostureadjust.service.LhfLocadisService;


@Service("lhfLocadisService")
public class LhfLocadisServiceImpl extends ServiceImpl<LhfLocadisDao, LhfLocadisEntity> implements LhfLocadisService {

    @Autowired
    LhfLocadisDao lhfLocadisDao;

    @Override
    public List<LhfLocadisEntity> getLi(int id) {
        List<LhfLocadisEntity> last = lhfLocadisDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LhfLocadisEntity> page = this.page(
                new Query<LhfLocadisEntity>().getPage(params),
                new QueryWrapper<LhfLocadisEntity>()
        );

        return new PageUtils(page);
    }

}