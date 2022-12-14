package com.iapmhad.yh_postureadjust.service.impl;

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

import com.iapmhad.yh_postureadjust.dao.HoleMeasureDao;
import com.iapmhad.yh_postureadjust.entity.HoleMeasureEntity;
import com.iapmhad.yh_postureadjust.service.HoleMeasureService;


@Service("holeMeasureService")
public class HoleMeasureServiceImpl extends ServiceImpl<HoleMeasureDao, HoleMeasureEntity> implements HoleMeasureService {

    @Autowired
    HoleMeasureDao holeMeasureDao;

    @Override
    public List<HoleMeasureEntity> getLi(int id) {
        List<HoleMeasureEntity> last = holeMeasureDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HoleMeasureEntity> page = this.page(
                new Query<HoleMeasureEntity>().getPage(params),
                new QueryWrapper<HoleMeasureEntity>()
        );

        return new PageUtils(page);
    }

}