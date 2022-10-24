package com.iapmhad.jydbjdj.service.impl;

import com.iapmhad.jydbjdj.dao.RwLocadisDao;
import com.iapmhad.jydbjdj.entity.RwLocadisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.jydbjdj.dao.RwLocaloadDao;
import com.iapmhad.jydbjdj.entity.RwLocaloadEntity;
import com.iapmhad.jydbjdj.service.RwLocaloadService;


@Service("rwLocaloadService")
public class RwLocaloadServiceImpl extends ServiceImpl<RwLocaloadDao, RwLocaloadEntity> implements RwLocaloadService {

    @Autowired
    RwLocaloadDao rwLocaloadDao;

    @Override
    public List<RwLocaloadEntity> getLi(int id) {
        List<RwLocaloadEntity> last = rwLocaloadDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RwLocaloadEntity> page = this.page(
                new Query<RwLocaloadEntity>().getPage(params),
                new QueryWrapper<RwLocaloadEntity>()
        );

        return new PageUtils(page);
    }

}