package com.iapmhad.processParametersJqrzk.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.processParametersJqrzk.dao.ModifyLogDao;
import com.iapmhad.processParametersJqrzk.entity.ModifyLogEntity;
import com.iapmhad.processParametersJqrzk.service.ModifyLogService;


@Service("modifyLogService")
public class ModifyLogServiceImpl extends ServiceImpl<ModifyLogDao, ModifyLogEntity> implements ModifyLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ModifyLogEntity> page = this.page(
                new Query<ModifyLogEntity>().getPage(params),
                new QueryWrapper<ModifyLogEntity>()
        );

        return new PageUtils(page);
    }

}