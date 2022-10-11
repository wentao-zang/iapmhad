package com.iapmhad.yhpostureadjust.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LsBasestanDao;
import com.iapmhad.yhpostureadjust.entity.LsBasestanEntity;
import com.iapmhad.yhpostureadjust.service.LsBasestanService;


@Service("lsBasestanService")
public class LsBasestanServiceImpl extends ServiceImpl<LsBasestanDao, LsBasestanEntity> implements LsBasestanService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LsBasestanEntity> page = this.page(
                new Query<LsBasestanEntity>().getPage(params),
                new QueryWrapper<LsBasestanEntity>()
        );

        return new PageUtils(page);
    }

}