package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RxBasestanDao;
import com.iapmhad.yhpostureadjust.entity.RxBasestanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RxLocadis1Dao;
import com.iapmhad.yhpostureadjust.entity.RxLocadis1Entity;
import com.iapmhad.yhpostureadjust.service.RxLocadis1Service;


@Service("rxLocadis1Service")
public class RxLocadis1ServiceImpl extends ServiceImpl<RxLocadis1Dao, RxLocadis1Entity> implements RxLocadis1Service {

    @Autowired
    RxLocadis1Dao rxLocadis1Dao;

    @Override
    public List<RxLocadis1Entity> getLi(int id) {
        List<RxLocadis1Entity> last = rxLocadis1Dao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RxLocadis1Entity> page = this.page(
                new Query<RxLocadis1Entity>().getPage(params),
                new QueryWrapper<RxLocadis1Entity>()
        );

        return new PageUtils(page);
    }

}