package com.iapmhad.hdymzkjqrxt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.hdymzkjqrxt.dao.YdptinfoDao;
import com.iapmhad.hdymzkjqrxt.entity.YdptinfoEntity;
import com.iapmhad.hdymzkjqrxt.service.YdptinfoService;


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

    @Autowired
    YdptinfoDao YdptinfoDao;

    @Override
    public List<YdptinfoEntity> getLi(int id) {
        List<YdptinfoEntity> li = YdptinfoDao.getLi(id);
        return li;
    }
    @Override
    public YdptinfoEntity getLast() {
        YdptinfoEntity last=YdptinfoDao.getLast();
        return last;
    }

}