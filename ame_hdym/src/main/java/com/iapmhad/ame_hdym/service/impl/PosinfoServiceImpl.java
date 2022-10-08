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

import com.iapmhad.ame_hdym.dao.PosinfoDao;
import com.iapmhad.ame_hdym.entity.PosinfoEntity;
import com.iapmhad.ame_hdym.service.PosinfoService;


@Service("posinfoService")
public class PosinfoServiceImpl extends ServiceImpl<PosinfoDao, PosinfoEntity> implements PosinfoService {

    @Autowired
    PosinfoService posinfoService;

    @Override
    public List<PosinfoEntity> getLi(int id) {
        List<PosinfoEntity> li = posinfoService.getLi(id);
        return li;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PosinfoEntity> page = this.page(
                new Query<PosinfoEntity>().getPage(params),
                new QueryWrapper<PosinfoEntity>()
        );

        return new PageUtils(page);
    }

}