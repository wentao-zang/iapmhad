package com.iapmhad.yhmachinedrilling.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhmachinedrilling.dao.HoleMeasureDao;
import com.iapmhad.yhmachinedrilling.entity.HoleMeasureEntity;
import com.iapmhad.yhmachinedrilling.service.HoleMeasureService;


@Service("holeMeasureService")
public class HoleMeasureServiceImpl extends ServiceImpl<HoleMeasureDao, HoleMeasureEntity> implements HoleMeasureService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HoleMeasureEntity> page = this.page(
                new Query<HoleMeasureEntity>().getPage(params),
                new QueryWrapper<HoleMeasureEntity>()
        );

        return new PageUtils(page);
    }

}