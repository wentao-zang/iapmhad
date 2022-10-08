package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.SetstationDao;
import com.iapmhad.ame_hdym.entity.SetstationEntity;
import com.iapmhad.ame_hdym.service.SetstationService;


@Service("setstationService")
public class SetstationServiceImpl extends ServiceImpl<SetstationDao, SetstationEntity> implements SetstationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SetstationEntity> page = this.page(
                new Query<SetstationEntity>().getPage(params),
                new QueryWrapper<SetstationEntity>()
        );

        return new PageUtils(page);
    }

}