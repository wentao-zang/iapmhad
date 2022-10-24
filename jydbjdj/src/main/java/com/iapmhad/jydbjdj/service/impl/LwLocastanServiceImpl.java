package com.iapmhad.jydbjdj.service.impl;

import com.iapmhad.jydbjdj.dao.LwLocaloadDao;
import com.iapmhad.jydbjdj.entity.LwLocaloadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.jydbjdj.dao.LwLocastanDao;
import com.iapmhad.jydbjdj.entity.LwLocastanEntity;
import com.iapmhad.jydbjdj.service.LwLocastanService;


@Service("lwLocastanService")
public class LwLocastanServiceImpl extends ServiceImpl<LwLocastanDao, LwLocastanEntity> implements LwLocastanService {

    @Autowired
    LwLocastanDao lwLocastanDao;

    @Override
    public List<LwLocastanEntity> getLi(int id) {
        List<LwLocastanEntity> last = lwLocastanDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LwLocastanEntity> page = this.page(
                new Query<LwLocastanEntity>().getPage(params),
                new QueryWrapper<LwLocastanEntity>()
        );

        return new PageUtils(page);
    }

}