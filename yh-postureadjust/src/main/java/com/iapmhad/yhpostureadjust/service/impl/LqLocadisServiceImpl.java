package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LqLocadisDao;
import com.iapmhad.yhpostureadjust.entity.LqLocadisEntity;
import com.iapmhad.yhpostureadjust.service.LqLocadisService;


@Service("lqLocadisService")
public class LqLocadisServiceImpl extends ServiceImpl<LqLocadisDao, LqLocadisEntity> implements LqLocadisService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LqLocadisEntity> page = this.page(
                new Query<LqLocadisEntity>().getPage(params),
                new QueryWrapper<LqLocadisEntity>()
        );

        return new PageUtils(page);
    }

}