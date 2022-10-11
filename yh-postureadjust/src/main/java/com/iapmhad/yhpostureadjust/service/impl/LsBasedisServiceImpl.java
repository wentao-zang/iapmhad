package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LsBasedisDao;
import com.iapmhad.yhpostureadjust.entity.LsBasedisEntity;
import com.iapmhad.yhpostureadjust.service.LsBasedisService;


@Service("lsBasedisService")
public class LsBasedisServiceImpl extends ServiceImpl<LsBasedisDao, LsBasedisEntity> implements LsBasedisService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LsBasedisEntity> page = this.page(
                new Query<LsBasedisEntity>().getPage(params),
                new QueryWrapper<LsBasedisEntity>()
        );

        return new PageUtils(page);
    }

}