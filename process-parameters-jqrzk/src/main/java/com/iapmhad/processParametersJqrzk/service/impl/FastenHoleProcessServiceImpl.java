package com.iapmhad.processParametersJqrzk.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.processParametersJqrzk.dao.FastenHoleProcessDao;
import com.iapmhad.processParametersJqrzk.entity.FastenHoleProcessEntity;
import com.iapmhad.processParametersJqrzk.service.FastenHoleProcessService;


@Service("fastenHoleProcessService")
public class FastenHoleProcessServiceImpl extends ServiceImpl<FastenHoleProcessDao, FastenHoleProcessEntity> implements FastenHoleProcessService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FastenHoleProcessEntity> page = this.page(
                new Query<FastenHoleProcessEntity>().getPage(params),
                new QueryWrapper<FastenHoleProcessEntity>()
        );

        return new PageUtils(page);
    }

}