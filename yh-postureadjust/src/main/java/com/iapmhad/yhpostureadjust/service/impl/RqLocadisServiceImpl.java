package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LxLocastan2Dao;
import com.iapmhad.yhpostureadjust.entity.LxLocastan2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RqLocadisDao;
import com.iapmhad.yhpostureadjust.entity.RqLocadisEntity;
import com.iapmhad.yhpostureadjust.service.RqLocadisService;


@Service("rqLocadisService")
public class RqLocadisServiceImpl extends ServiceImpl<RqLocadisDao, RqLocadisEntity> implements RqLocadisService {

    @Autowired
    RqLocadisDao rqLocadisDao;

    @Override
    public List<RqLocadisEntity> getLi(int id) {
        List<RqLocadisEntity> last = rqLocadisDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RqLocadisEntity> page = this.page(
                new Query<RqLocadisEntity>().getPage(params),
                new QueryWrapper<RqLocadisEntity>()
        );

        return new PageUtils(page);
    }

}