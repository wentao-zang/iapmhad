package com.iapmhad.jydbjdj.service.impl;

import com.iapmhad.jydbjdj.dao.LwLocadisDao;
import com.iapmhad.jydbjdj.entity.LwLocadisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.jydbjdj.dao.LwLocaloadDao;
import com.iapmhad.jydbjdj.entity.LwLocaloadEntity;
import com.iapmhad.jydbjdj.service.LwLocaloadService;


@Service("lwLocaloadService")
public class LwLocaloadServiceImpl extends ServiceImpl<LwLocaloadDao, LwLocaloadEntity> implements LwLocaloadService {

    @Autowired
    LwLocaloadDao lwLocaloadDao;

    @Override
    public List<LwLocaloadEntity> getLi(int id) {
        List<LwLocaloadEntity> last = lwLocaloadDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LwLocaloadEntity> page = this.page(
                new Query<LwLocaloadEntity>().getPage(params),
                new QueryWrapper<LwLocaloadEntity>()
        );

        return new PageUtils(page);
    }

}