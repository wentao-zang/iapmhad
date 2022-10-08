package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.AxistempDao;
import com.iapmhad.ame_hdym.entity.AxistempEntity;
import com.iapmhad.ame_hdym.service.AxistempService;


@Service("axistempService")
public class AxistempServiceImpl extends ServiceImpl<AxistempDao, AxistempEntity> implements AxistempService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AxistempEntity> page = this.page(
                new Query<AxistempEntity>().getPage(params),
                new QueryWrapper<AxistempEntity>()
        );

        return new PageUtils(page);
    }

}