package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.LhfLocadisDao;
import com.iapmhad.yhpostureadjust.entity.LhfLocadisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.LhfLocastanDao;
import com.iapmhad.yhpostureadjust.entity.LhfLocastanEntity;
import com.iapmhad.yhpostureadjust.service.LhfLocastanService;


@Service("lhfLocastanService")
public class LhfLocastanServiceImpl extends ServiceImpl<LhfLocastanDao, LhfLocastanEntity> implements LhfLocastanService {

    @Autowired
    LhfLocastanDao lhfLocastanDao;

    @Override
    public List<LhfLocastanEntity> getLi(int id) {
        List<LhfLocastanEntity> last = lhfLocastanDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LhfLocastanEntity> page = this.page(
                new Query<LhfLocastanEntity>().getPage(params),
                new QueryWrapper<LhfLocastanEntity>()
        );

        return new PageUtils(page);
    }

}