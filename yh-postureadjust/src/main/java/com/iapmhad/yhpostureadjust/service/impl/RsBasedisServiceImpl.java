package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RqLocastanDao;
import com.iapmhad.yhpostureadjust.entity.RqLocastanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RsBasedisDao;
import com.iapmhad.yhpostureadjust.entity.RsBasedisEntity;
import com.iapmhad.yhpostureadjust.service.RsBasedisService;


@Service("rsBasedisService")
public class RsBasedisServiceImpl extends ServiceImpl<RsBasedisDao, RsBasedisEntity> implements RsBasedisService {

    @Autowired
    RsBasedisDao rsBasedisDao;

    @Override
    public List<RsBasedisEntity> getLi(int id) {
        List<RsBasedisEntity> last = rsBasedisDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RsBasedisEntity> page = this.page(
                new Query<RsBasedisEntity>().getPage(params),
                new QueryWrapper<RsBasedisEntity>()
        );

        return new PageUtils(page);
    }

}