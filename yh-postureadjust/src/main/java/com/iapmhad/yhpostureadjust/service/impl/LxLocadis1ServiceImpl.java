package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LxBasestanDao;
import com.iapmhad.yhpostureadjust.entity.LxBasestanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LxLocadis1Dao;
import com.iapmhad.yhpostureadjust.entity.LxLocadis1Entity;
import com.iapmhad.yhpostureadjust.service.LxLocadis1Service;


@Service("lxLocadis1Service")
public class LxLocadis1ServiceImpl extends ServiceImpl<LxLocadis1Dao, LxLocadis1Entity> implements LxLocadis1Service {

    @Autowired
    LxLocadis1Dao lxLocadis1Dao;

    @Override
    public List<LxLocadis1Entity> getLi(int id) {
        List<LxLocadis1Entity> last = lxLocadis1Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LxLocadis1Entity> page = this.page(
                new Query<LxLocadis1Entity>().getPage(params),
                new QueryWrapper<LxLocadis1Entity>()
        );

        return new PageUtils(page);
    }

}