package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.StatusinfoDao;
import com.iapmhad.ame_hdym.entity.StatusinfoEntity;
import com.iapmhad.ame_hdym.service.StatusinfoService;


@Service("statusinfoService")
public class StatusinfoServiceImpl extends ServiceImpl<StatusinfoDao, StatusinfoEntity> implements StatusinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StatusinfoEntity> page = this.page(
                new Query<StatusinfoEntity>().getPage(params),
                new QueryWrapper<StatusinfoEntity>()
        );

        return new PageUtils(page);
    }

}