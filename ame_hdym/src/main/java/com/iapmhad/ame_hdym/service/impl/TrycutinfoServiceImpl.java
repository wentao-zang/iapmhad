package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.TrycutinfoDao;
import com.iapmhad.ame_hdym.entity.TrycutinfoEntity;
import com.iapmhad.ame_hdym.service.TrycutinfoService;


@Service("trycutinfoService")
public class TrycutinfoServiceImpl extends ServiceImpl<TrycutinfoDao, TrycutinfoEntity> implements TrycutinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TrycutinfoEntity> page = this.page(
                new Query<TrycutinfoEntity>().getPage(params),
                new QueryWrapper<TrycutinfoEntity>()
        );

        return new PageUtils(page);
    }

}