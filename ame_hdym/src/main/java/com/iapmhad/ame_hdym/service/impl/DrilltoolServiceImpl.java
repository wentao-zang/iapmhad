package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.DrilltoolDao;
import com.iapmhad.ame_hdym.entity.DrilltoolEntity;
import com.iapmhad.ame_hdym.service.DrilltoolService;


@Service("drilltoolService")
public class DrilltoolServiceImpl extends ServiceImpl<DrilltoolDao, DrilltoolEntity> implements DrilltoolService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DrilltoolEntity> page = this.page(
                new Query<DrilltoolEntity>().getPage(params),
                new QueryWrapper<DrilltoolEntity>()
        );

        return new PageUtils(page);
    }

}