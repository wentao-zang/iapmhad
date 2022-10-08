package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.HoleNormalmodifyDao;
import com.iapmhad.ame_hdym.entity.HoleNormalmodifyEntity;
import com.iapmhad.ame_hdym.service.HoleNormalmodifyService;


@Service("holeNormalmodifyService")
public class HoleNormalmodifyServiceImpl extends ServiceImpl<HoleNormalmodifyDao, HoleNormalmodifyEntity> implements HoleNormalmodifyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HoleNormalmodifyEntity> page = this.page(
                new Query<HoleNormalmodifyEntity>().getPage(params),
                new QueryWrapper<HoleNormalmodifyEntity>()
        );

        return new PageUtils(page);
    }

}