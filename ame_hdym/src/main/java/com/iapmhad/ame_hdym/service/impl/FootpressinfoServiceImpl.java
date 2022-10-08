package com.iapmhad.ame_hdym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.FootpressinfoDao;
import com.iapmhad.ame_hdym.entity.FootpressinfoEntity;
import com.iapmhad.ame_hdym.service.FootpressinfoService;


@Service("footpressinfoService")
public class FootpressinfoServiceImpl extends ServiceImpl<FootpressinfoDao, FootpressinfoEntity> implements FootpressinfoService {

    @Autowired
    FootpressinfoDao footpressinfoDao;

    @Override
    public List<FootpressinfoEntity> getLi(int id) {
        List<FootpressinfoEntity> li = footpressinfoDao.getLi(id);
        return li;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FootpressinfoEntity> page = this.page(
                new Query<FootpressinfoEntity>().getPage(params),
                new QueryWrapper<FootpressinfoEntity>()
        );

        return new PageUtils(page);
    }

}