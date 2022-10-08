package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.HolediameasDao;
import com.iapmhad.ame_hdym.entity.HolediameasEntity;
import com.iapmhad.ame_hdym.service.HolediameasService;


@Service("holediameasService")
public class HolediameasServiceImpl extends ServiceImpl<HolediameasDao, HolediameasEntity> implements HolediameasService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HolediameasEntity> page = this.page(
                new Query<HolediameasEntity>().getPage(params),
                new QueryWrapper<HolediameasEntity>()
        );

        return new PageUtils(page);
    }

}