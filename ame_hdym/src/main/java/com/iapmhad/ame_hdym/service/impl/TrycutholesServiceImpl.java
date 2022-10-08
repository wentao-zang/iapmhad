package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.TrycutholesDao;
import com.iapmhad.ame_hdym.entity.TrycutholesEntity;
import com.iapmhad.ame_hdym.service.TrycutholesService;


@Service("trycutholesService")
public class TrycutholesServiceImpl extends ServiceImpl<TrycutholesDao, TrycutholesEntity> implements TrycutholesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TrycutholesEntity> page = this.page(
                new Query<TrycutholesEntity>().getPage(params),
                new QueryWrapper<TrycutholesEntity>()
        );

        return new PageUtils(page);
    }

}