package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
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

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RqLocadisEntity> page = this.page(
                new Query<RqLocadisEntity>().getPage(params),
                new QueryWrapper<RqLocadisEntity>()
        );

        return new PageUtils(page);
    }

}