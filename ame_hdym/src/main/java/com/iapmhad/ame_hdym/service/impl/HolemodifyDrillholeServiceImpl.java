package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.HolemodifyDrillholeDao;
import com.iapmhad.ame_hdym.entity.HolemodifyDrillholeEntity;
import com.iapmhad.ame_hdym.service.HolemodifyDrillholeService;


@Service("holemodifyDrillholeService")
public class HolemodifyDrillholeServiceImpl extends ServiceImpl<HolemodifyDrillholeDao, HolemodifyDrillholeEntity> implements HolemodifyDrillholeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HolemodifyDrillholeEntity> page = this.page(
                new Query<HolemodifyDrillholeEntity>().getPage(params),
                new QueryWrapper<HolemodifyDrillholeEntity>()
        );

        return new PageUtils(page);
    }

}