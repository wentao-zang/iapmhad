package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RsBasedisDao;
import com.iapmhad.yhpostureadjust.entity.RsBasedisEntity;
import com.iapmhad.yhpostureadjust.service.RsBasedisService;


@Service("rsBasedisService")
public class RsBasedisServiceImpl extends ServiceImpl<RsBasedisDao, RsBasedisEntity> implements RsBasedisService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RsBasedisEntity> page = this.page(
                new Query<RsBasedisEntity>().getPage(params),
                new QueryWrapper<RsBasedisEntity>()
        );

        return new PageUtils(page);
    }

}