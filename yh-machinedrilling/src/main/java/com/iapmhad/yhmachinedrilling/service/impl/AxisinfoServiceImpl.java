package com.iapmhad.yhmachinedrilling.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhmachinedrilling.dao.AxisinfoDao;
import com.iapmhad.yhmachinedrilling.entity.AxisinfoEntity;
import com.iapmhad.yhmachinedrilling.service.AxisinfoService;


@Service("axisinfoService")
public class AxisinfoServiceImpl extends ServiceImpl<AxisinfoDao, AxisinfoEntity> implements AxisinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AxisinfoEntity> page = this.page(
                new Query<AxisinfoEntity>().getPage(params),
                new QueryWrapper<AxisinfoEntity>()
        );

        return new PageUtils(page);
    }

}