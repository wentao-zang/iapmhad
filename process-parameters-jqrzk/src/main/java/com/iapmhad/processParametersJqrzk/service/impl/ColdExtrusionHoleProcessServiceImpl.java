package com.iapmhad.processParametersJqrzk.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.processParametersJqrzk.dao.ColdExtrusionHoleProcessDao;
import com.iapmhad.processParametersJqrzk.entity.ColdExtrusionHoleProcessEntity;
import com.iapmhad.processParametersJqrzk.service.ColdExtrusionHoleProcessService;


@Service("coldExtrusionHoleProcessService")
public class ColdExtrusionHoleProcessServiceImpl extends ServiceImpl<ColdExtrusionHoleProcessDao, ColdExtrusionHoleProcessEntity> implements ColdExtrusionHoleProcessService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ColdExtrusionHoleProcessEntity> page = this.page(
                new Query<ColdExtrusionHoleProcessEntity>().getPage(params),
                new QueryWrapper<ColdExtrusionHoleProcessEntity>()
        );

        return new PageUtils(page);
    }

}