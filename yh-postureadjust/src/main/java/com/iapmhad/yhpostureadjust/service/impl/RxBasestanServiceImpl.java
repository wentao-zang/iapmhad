package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RxBasedisDao;
import com.iapmhad.yhpostureadjust.entity.RxBasedisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RxBasestanDao;
import com.iapmhad.yhpostureadjust.entity.RxBasestanEntity;
import com.iapmhad.yhpostureadjust.service.RxBasestanService;


@Service("rxBasestanService")
public class RxBasestanServiceImpl extends ServiceImpl<RxBasestanDao, RxBasestanEntity> implements RxBasestanService {

    @Autowired
    RxBasestanDao rxBasestanDao;

    @Override
    public List<RxBasestanEntity> getLi(int id) {
        List<RxBasestanEntity> last = rxBasestanDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RxBasestanEntity> page = this.page(
                new Query<RxBasestanEntity>().getPage(params),
                new QueryWrapper<RxBasestanEntity>()
        );

        return new PageUtils(page);
    }

}