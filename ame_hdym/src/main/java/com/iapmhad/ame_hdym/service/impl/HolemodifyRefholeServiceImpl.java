package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.HolemodifyRefholeDao;
import com.iapmhad.ame_hdym.entity.HolemodifyRefholeEntity;
import com.iapmhad.ame_hdym.service.HolemodifyRefholeService;


@Service("holemodifyRefholeService")
public class HolemodifyRefholeServiceImpl extends ServiceImpl<HolemodifyRefholeDao, HolemodifyRefholeEntity> implements HolemodifyRefholeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HolemodifyRefholeEntity> page = this.page(
                new Query<HolemodifyRefholeEntity>().getPage(params),
                new QueryWrapper<HolemodifyRefholeEntity>()
        );

        return new PageUtils(page);
    }

}