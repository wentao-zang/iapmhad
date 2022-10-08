package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.DrillprocessDao;
import com.iapmhad.ame_hdym.entity.DrillprocessEntity;
import com.iapmhad.ame_hdym.service.DrillprocessService;


@Service("drillprocessService")
public class DrillprocessServiceImpl extends ServiceImpl<DrillprocessDao, DrillprocessEntity> implements DrillprocessService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrillprocessEntity> page = this.page(
                new Query<DrillprocessEntity>().getPage(params),
                new QueryWrapper<DrillprocessEntity>()
        );

        return new PageUtils(page);
    }

}