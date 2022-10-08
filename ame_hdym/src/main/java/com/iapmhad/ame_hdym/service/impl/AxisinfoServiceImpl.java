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

import com.iapmhad.ame_hdym.dao.AxisinfoDao;
import com.iapmhad.ame_hdym.entity.AxisinfoEntity;
import com.iapmhad.ame_hdym.service.AxisinfoService;


@Service("axisinfoService")
public class AxisinfoServiceImpl extends ServiceImpl<AxisinfoDao, AxisinfoEntity> implements AxisinfoService {

    @Autowired
    AxisinfoDao axisinfoDao;

    @Override
    public List<AxisinfoEntity> getLi(int id) {
        List<AxisinfoEntity> li = axisinfoDao.getLi(id);
        return li;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AxisinfoEntity> page = this.page(
                new Query<AxisinfoEntity>().getPage(params),
                new QueryWrapper<AxisinfoEntity>()
        );

        return new PageUtils(page);
    }

}