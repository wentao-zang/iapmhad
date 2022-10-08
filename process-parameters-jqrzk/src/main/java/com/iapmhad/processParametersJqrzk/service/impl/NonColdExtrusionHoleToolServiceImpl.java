package com.iapmhad.processParametersJqrzk.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.processParametersJqrzk.dao.NonColdExtrusionHoleToolDao;
import com.iapmhad.processParametersJqrzk.entity.NonColdExtrusionHoleToolEntity;
import com.iapmhad.processParametersJqrzk.service.NonColdExtrusionHoleToolService;


@Service("nonColdExtrusionHoleToolService")
public class NonColdExtrusionHoleToolServiceImpl extends ServiceImpl<NonColdExtrusionHoleToolDao, NonColdExtrusionHoleToolEntity> implements NonColdExtrusionHoleToolService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NonColdExtrusionHoleToolEntity> page = this.page(
                new Query<NonColdExtrusionHoleToolEntity>().getPage(params),
                new QueryWrapper<NonColdExtrusionHoleToolEntity>()
        );

        return new PageUtils(page);
    }

}