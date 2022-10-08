package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.StationholeDao;
import com.iapmhad.ame_hdym.entity.StationholeEntity;
import com.iapmhad.ame_hdym.service.StationholeService;


@Service("stationholeService")
public class StationholeServiceImpl extends ServiceImpl<StationholeDao, StationholeEntity> implements StationholeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StationholeEntity> page = this.page(
                new Query<StationholeEntity>().getPage(params),
                new QueryWrapper<StationholeEntity>()
        );

        return new PageUtils(page);
    }

}