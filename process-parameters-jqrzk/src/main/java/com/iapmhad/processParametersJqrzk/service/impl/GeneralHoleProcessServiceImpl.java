package com.iapmhad.processParametersJqrzk.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.processParametersJqrzk.dao.GeneralHoleProcessDao;
import com.iapmhad.processParametersJqrzk.entity.GeneralHoleProcessEntity;
import com.iapmhad.processParametersJqrzk.service.GeneralHoleProcessService;


@Service("generalHoleProcessService")
public class GeneralHoleProcessServiceImpl extends ServiceImpl<GeneralHoleProcessDao, GeneralHoleProcessEntity> implements GeneralHoleProcessService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GeneralHoleProcessEntity> page = this.page(
                new Query<GeneralHoleProcessEntity>().getPage(params),
                new QueryWrapper<GeneralHoleProcessEntity>()
        );

        return new PageUtils(page);
    }

}