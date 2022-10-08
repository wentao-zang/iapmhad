package com.iapmhad.processParametersJqrzk.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.processParametersJqrzk.dao.FastenDao;
import com.iapmhad.processParametersJqrzk.entity.FastenEntity;
import com.iapmhad.processParametersJqrzk.service.FastenService;


@Service("fastenService")
public class FastenServiceImpl extends ServiceImpl<FastenDao, FastenEntity> implements FastenService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FastenEntity> page = this.page(
                new Query<FastenEntity>().getPage(params),
                new QueryWrapper<FastenEntity>()
        );

        return new PageUtils(page);
    }

}