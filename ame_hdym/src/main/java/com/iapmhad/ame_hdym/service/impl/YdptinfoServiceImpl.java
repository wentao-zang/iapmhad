package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.YdptinfoDao;
import com.iapmhad.ame_hdym.entity.YdptinfoEntity;
import com.iapmhad.ame_hdym.service.YdptinfoService;


@Service("ydptinfoService")
public class YdptinfoServiceImpl extends ServiceImpl<YdptinfoDao, YdptinfoEntity> implements YdptinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<YdptinfoEntity> page = this.page(
                new Query<YdptinfoEntity>().getPage(params),
                new QueryWrapper<YdptinfoEntity>()
        );

        return new PageUtils(page);
    }

}