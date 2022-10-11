package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RqLocastanDao;
import com.iapmhad.yhpostureadjust.entity.RqLocastanEntity;
import com.iapmhad.yhpostureadjust.service.RqLocastanService;


@Service("rqLocastanService")
public class RqLocastanServiceImpl extends ServiceImpl<RqLocastanDao, RqLocastanEntity> implements RqLocastanService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RqLocastanEntity> page = this.page(
                new Query<RqLocastanEntity>().getPage(params),
                new QueryWrapper<RqLocastanEntity>()
        );

        return new PageUtils(page);
    }

}