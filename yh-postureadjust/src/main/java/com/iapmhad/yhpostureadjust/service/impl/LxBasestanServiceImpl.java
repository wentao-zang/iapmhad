package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LsLocastan1Dao;
import com.iapmhad.yhpostureadjust.entity.LsLocastan1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LxBasestanDao;
import com.iapmhad.yhpostureadjust.entity.LxBasestanEntity;
import com.iapmhad.yhpostureadjust.service.LxBasestanService;


@Service("lxBasestanService")
public class LxBasestanServiceImpl extends ServiceImpl<LxBasestanDao, LxBasestanEntity> implements LxBasestanService {

    @Autowired
    LxBasestanDao lxBasestanDao;

    @Override
    public List<LxBasestanEntity> getLi(int id) {
        List<LxBasestanEntity> last = lxBasestanDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LxBasestanEntity> page = this.page(
                new Query<LxBasestanEntity>().getPage(params),
                new QueryWrapper<LxBasestanEntity>()
        );

        return new PageUtils(page);
    }

}