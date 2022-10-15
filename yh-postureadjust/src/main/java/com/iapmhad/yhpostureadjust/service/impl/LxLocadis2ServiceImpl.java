package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LxLocadis1Dao;
import com.iapmhad.yhpostureadjust.entity.LxLocadis1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LxLocadis2Dao;
import com.iapmhad.yhpostureadjust.entity.LxLocadis2Entity;
import com.iapmhad.yhpostureadjust.service.LxLocadis2Service;


@Service("lxLocadis2Service")
public class LxLocadis2ServiceImpl extends ServiceImpl<LxLocadis2Dao, LxLocadis2Entity> implements LxLocadis2Service {

    @Autowired
    LxLocadis2Dao lxLocadis2Dao;

    @Override
    public List<LxLocadis2Entity> getLi(int id) {
        List<LxLocadis2Entity> last = lxLocadis2Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LxLocadis2Entity> page = this.page(
                new Query<LxLocadis2Entity>().getPage(params),
                new QueryWrapper<LxLocadis2Entity>()
        );

        return new PageUtils(page);
    }

}