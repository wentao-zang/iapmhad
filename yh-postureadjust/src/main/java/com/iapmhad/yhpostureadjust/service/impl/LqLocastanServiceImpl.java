package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.entity.LsLocadis1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LqLocastanDao;
import com.iapmhad.yhpostureadjust.entity.LqLocastanEntity;
import com.iapmhad.yhpostureadjust.service.LqLocastanService;


@Service("lqLocastanService")
public class LqLocastanServiceImpl extends ServiceImpl<LqLocastanDao, LqLocastanEntity> implements LqLocastanService {


    @Autowired
    LqLocastanDao lqLocastanDao;

    @Override
    public List<LqLocastanEntity> getLi(int id) {
        List<LqLocastanEntity> last = lqLocastanDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LqLocastanEntity> page = this.page(
                new Query<LqLocastanEntity>().getPage(params),
                new QueryWrapper<LqLocastanEntity>()
        );

        return new PageUtils(page);
    }

}