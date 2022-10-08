package com.iapmhad.processParametersJqrzk.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.processParametersJqrzk.dao.ColdExtrusionHoleToolDao;
import com.iapmhad.processParametersJqrzk.entity.ColdExtrusionHoleToolEntity;
import com.iapmhad.processParametersJqrzk.service.ColdExtrusionHoleToolService;


@Service("coldExtrusionHoleToolService")
public class ColdExtrusionHoleToolServiceImpl extends ServiceImpl<ColdExtrusionHoleToolDao, ColdExtrusionHoleToolEntity> implements ColdExtrusionHoleToolService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ColdExtrusionHoleToolEntity> page = this.page(
                new Query<ColdExtrusionHoleToolEntity>().getPage(params),
                new QueryWrapper<ColdExtrusionHoleToolEntity>()
        );

        return new PageUtils(page);
    }

}