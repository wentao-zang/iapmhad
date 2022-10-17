package com.iapmhad.yhpostureadjust.service.impl;

import com.iapmhad.yhpostureadjust.dao.RhfLocadisDao;
import com.iapmhad.yhpostureadjust.entity.RhfLocadisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhpostureadjust.dao.RhfLocastanDao;
import com.iapmhad.yhpostureadjust.entity.RhfLocastanEntity;
import com.iapmhad.yhpostureadjust.service.RhfLocastanService;


@Service("rhfLocastanService")
public class RhfLocastanServiceImpl extends ServiceImpl<RhfLocastanDao, RhfLocastanEntity> implements RhfLocastanService {

    @Autowired
    RhfLocastanDao rhfLocastanDao;

    @Override
    public List<RhfLocastanEntity> getLi(int id) {
        List<RhfLocastanEntity> last = rhfLocastanDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RhfLocastanEntity> page = this.page(
                new Query<RhfLocastanEntity>().getPage(params),
                new QueryWrapper<RhfLocastanEntity>()
        );

        return new PageUtils(page);
    }

}