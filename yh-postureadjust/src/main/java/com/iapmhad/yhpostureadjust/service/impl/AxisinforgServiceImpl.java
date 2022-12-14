package com.iapmhad.yh_postureadjust.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yh_postureadjust.dao.AxisinforgDao;
import com.iapmhad.yh_postureadjust.entity.AxisinforgEntity;
import com.iapmhad.yh_postureadjust.service.AxisinforgService;


@Service("axisinforgService")
public class AxisinforgServiceImpl extends ServiceImpl<AxisinforgDao, AxisinforgEntity> implements AxisinforgService {

    @Autowired
    AxisinforgDao axisinforgDao;

    @Override
    public List<AxisinforgEntity> getLi(int id) {
        List<AxisinforgEntity> last = axisinforgDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AxisinforgEntity> page = this.page(
                new Query<AxisinforgEntity>().getPage(params),
                new QueryWrapper<AxisinforgEntity>()
        );

        return new PageUtils(page);
    }

}