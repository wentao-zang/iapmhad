package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RsLocadis1Dao;
import com.iapmhad.yhpostureadjust.entity.RsLocadis1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RsLocadis2Dao;
import com.iapmhad.yhpostureadjust.entity.RsLocadis2Entity;
import com.iapmhad.yhpostureadjust.service.RsLocadis2Service;


@Service("rsLocadis2Service")
public class RsLocadis2ServiceImpl extends ServiceImpl<RsLocadis2Dao, RsLocadis2Entity> implements RsLocadis2Service {

    @Autowired
    RsLocadis2Dao rsLocadis2Dao;

    @Override
    public List<RsLocadis2Entity> getLi(int id) {
        List<RsLocadis2Entity> last = rsLocadis2Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RsLocadis2Entity> page = this.page(
                new Query<RsLocadis2Entity>().getPage(params),
                new QueryWrapper<RsLocadis2Entity>()
        );

        return new PageUtils(page);
    }

}