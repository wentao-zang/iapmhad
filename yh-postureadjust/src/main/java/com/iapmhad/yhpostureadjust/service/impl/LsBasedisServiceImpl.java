package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.entity.LqLocastanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LsBasedisDao;
import com.iapmhad.yhpostureadjust.entity.LsBasedisEntity;
import com.iapmhad.yhpostureadjust.service.LsBasedisService;


@Service("lsBasedisService")
public class LsBasedisServiceImpl extends ServiceImpl<LsBasedisDao, LsBasedisEntity> implements LsBasedisService {

    @Autowired
    LsBasedisDao lsBasedisDao;

    @Override
    public List<LsBasedisEntity> getLi(int id) {
        List<LsBasedisEntity> last = lsBasedisDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LsBasedisEntity> page = this.page(
                new Query<LsBasedisEntity>().getPage(params),
                new QueryWrapper<LsBasedisEntity>()
        );

        return new PageUtils(page);
    }

}