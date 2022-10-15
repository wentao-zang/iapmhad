package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RsLocastan2Dao;
import com.iapmhad.yhpostureadjust.entity.RsLocastan2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RxBasedisDao;
import com.iapmhad.yhpostureadjust.entity.RxBasedisEntity;
import com.iapmhad.yhpostureadjust.service.RxBasedisService;


@Service("rxBasedisService")
public class RxBasedisServiceImpl extends ServiceImpl<RxBasedisDao, RxBasedisEntity> implements RxBasedisService {

    @Autowired
    RxBasedisDao rxBasedisDao;

    @Override
    public List<RxBasedisEntity> getLi(int id) {
        List<RxBasedisEntity> last = rxBasedisDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RxBasedisEntity> page = this.page(
                new Query<RxBasedisEntity>().getPage(params),
                new QueryWrapper<RxBasedisEntity>()
        );

        return new PageUtils(page);
    }

}