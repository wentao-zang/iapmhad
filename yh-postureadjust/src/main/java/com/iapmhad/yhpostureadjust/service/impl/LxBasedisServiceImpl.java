package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
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

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LxBasedisEntity> page = this.page(
                new Query<LxBasedisEntity>().getPage(params),
                new QueryWrapper<LxBasedisEntity>()
        );

        return new PageUtils(page);
    }

}