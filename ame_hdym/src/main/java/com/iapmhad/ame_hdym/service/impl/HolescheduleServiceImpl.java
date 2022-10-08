package com.iapmhad.ame_hdym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.HolescheduleDao;
import com.iapmhad.ame_hdym.entity.HolescheduleEntity;
import com.iapmhad.ame_hdym.service.HolescheduleService;


@Service("holescheduleService")
public class HolescheduleServiceImpl extends ServiceImpl<HolescheduleDao, HolescheduleEntity> implements HolescheduleService {

    @Autowired
    HolescheduleDao holescheduleDao;

    @Override
    public HolescheduleEntity getLast() {
        HolescheduleEntity last = holescheduleDao.getLast();
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HolescheduleEntity> page = this.page(
                new Query<HolescheduleEntity>().getPage(params),
                new QueryWrapper<HolescheduleEntity>()
        );

        return new PageUtils(page);
    }

}