package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LxBasestanDao;
import com.iapmhad.yhpostureadjust.entity.LxBasestanEntity;
import com.iapmhad.yhpostureadjust.service.LxBasestanService;


@Service("lxBasestanService")
public class LxBasestanServiceImpl extends ServiceImpl<LxBasestanDao, LxBasestanEntity> implements LxBasestanService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LxBasestanEntity> page = this.page(
                new Query<LxBasestanEntity>().getPage(params),
                new QueryWrapper<LxBasestanEntity>()
        );

        return new PageUtils(page);
    }

}