package com.iapmhad.ame_hdym.service.impl;

import com.iapmhad.ame_hdym.dao.AxisinfoDao;
import com.iapmhad.ame_hdym.entity.AxisinfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.SpinfoDao;
import com.iapmhad.ame_hdym.entity.SpinfoEntity;
import com.iapmhad.ame_hdym.service.SpinfoService;


@Service("spinfoService")
public class SpinfoServiceImpl extends ServiceImpl<SpinfoDao, SpinfoEntity> implements SpinfoService {

    @Autowired
    SpinfoDao spinfoDao;

    @Override
    public List<SpinfoEntity> getLi(int id) {
        List<SpinfoEntity> li = spinfoDao.getLi(id);
        return li;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpinfoEntity> page = this.page(
                new Query<SpinfoEntity>().getPage(params),
                new QueryWrapper<SpinfoEntity>()
        );

        return new PageUtils(page);
    }

}