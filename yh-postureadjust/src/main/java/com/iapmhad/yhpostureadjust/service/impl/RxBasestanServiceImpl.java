package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
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

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RxBasestanEntity> page = this.page(
                new Query<RxBasestanEntity>().getPage(params),
                new QueryWrapper<RxBasestanEntity>()
        );

        return new PageUtils(page);
    }

}