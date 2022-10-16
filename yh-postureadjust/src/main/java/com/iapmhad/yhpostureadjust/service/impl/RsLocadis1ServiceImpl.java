package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RsBasestanDao;
import com.iapmhad.yhpostureadjust.entity.RsBasestanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RsLocadis1Dao;
import com.iapmhad.yhpostureadjust.entity.RsLocadis1Entity;
import com.iapmhad.yhpostureadjust.service.RsLocadis1Service;


@Service("rsLocadis1Service")
public class RsLocadis1ServiceImpl extends ServiceImpl<RsLocadis1Dao, RsLocadis1Entity> implements RsLocadis1Service {

    @Autowired
    RsLocadis1Dao rsLocadis1Dao;

    @Override
    public List<RsLocadis1Entity> getLi(int id) {
        List<RsLocadis1Entity> last = rsLocadis1Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RsLocadis1Entity> page = this.page(
                new Query<RsLocadis1Entity>().getPage(params),
                new QueryWrapper<RsLocadis1Entity>()
        );

        return new PageUtils(page);
    }

}