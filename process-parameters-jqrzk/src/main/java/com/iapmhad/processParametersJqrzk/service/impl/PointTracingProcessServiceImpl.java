package com.iapmhad.processParametersJqrzk.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.processParametersJqrzk.dao.PointTracingProcessDao;
import com.iapmhad.processParametersJqrzk.entity.PointTracingProcessEntity;
import com.iapmhad.processParametersJqrzk.service.PointTracingProcessService;


@Service("pointTracingProcessService")
public class PointTracingProcessServiceImpl extends ServiceImpl<PointTracingProcessDao, PointTracingProcessEntity> implements PointTracingProcessService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PointTracingProcessEntity> page = this.page(
                new Query<PointTracingProcessEntity>().getPage(params),
                new QueryWrapper<PointTracingProcessEntity>()
        );

        return new PageUtils(page);
    }

}