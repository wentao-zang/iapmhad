package com.iapmhad.processParametersJqrzk.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.processParametersJqrzk.dao.HoleMeasurementDao;
import com.iapmhad.processParametersJqrzk.entity.HoleMeasurementEntity;
import com.iapmhad.processParametersJqrzk.service.HoleMeasurementService;


@Service("holeMeasurementService")
public class HoleMeasurementServiceImpl extends ServiceImpl<HoleMeasurementDao, HoleMeasurementEntity> implements HoleMeasurementService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HoleMeasurementEntity> page = this.page(
                new Query<HoleMeasurementEntity>().getPage(params),
                new QueryWrapper<HoleMeasurementEntity>()
        );

        return new PageUtils(page);
    }

}