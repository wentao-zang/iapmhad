package com.iapmhad.yhpostureadjust.service.impl;

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

import com.iapmhad.yhpostureadjust.dao.LxBasedisDao;
import com.iapmhad.yhpostureadjust.entity.LxBasedisEntity;
import com.iapmhad.yhpostureadjust.service.LxBasedisService;


@Service("lxBasedisService")
public class LxBasedisServiceImpl extends ServiceImpl<LxBasedisDao, LxBasedisEntity> implements LxBasedisService {

    @Autowired
    LxBasedisDao lxBasedisDao;

    @Override
    public List<LxBasedisEntity> getLi(int id) {
        List<LxBasedisEntity> last = lxBasedisDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LxBasedisEntity> page = this.page(
                new Query<LxBasedisEntity>().getPage(params),
                new QueryWrapper<LxBasedisEntity>()
        );

        return new PageUtils(page);
    }

}