package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RsBasestanDao;
import com.iapmhad.yhpostureadjust.entity.RsBasestanEntity;
import com.iapmhad.yhpostureadjust.service.RsBasestanService;


@Service("rsBasestanService")
public class RsBasestanServiceImpl extends ServiceImpl<RsBasestanDao, RsBasestanEntity> implements RsBasestanService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RsBasestanEntity> page = this.page(
                new Query<RsBasestanEntity>().getPage(params),
                new QueryWrapper<RsBasestanEntity>()
        );

        return new PageUtils(page);
    }

}