package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.DpprocessDao;
import com.iapmhad.ame_hdym.entity.DpprocessEntity;
import com.iapmhad.ame_hdym.service.DpprocessService;


@Service("dpprocessService")
public class DpprocessServiceImpl extends ServiceImpl<DpprocessDao, DpprocessEntity> implements DpprocessService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DpprocessEntity> page = this.page(
                new Query<DpprocessEntity>().getPage(params),
                new QueryWrapper<DpprocessEntity>()
        );

        return new PageUtils(page);
    }

}