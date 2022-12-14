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

import com.iapmhad.yh_postureadjust.dao.AxisinfoleDao;
import com.iapmhad.yh_postureadjust.entity.AxisinfoleEntity;
import com.iapmhad.yh_postureadjust.service.AxisinfoleService;


@Service("axisinfoleService")
public class AxisinfoleServiceImpl extends ServiceImpl<AxisinfoleDao, AxisinfoleEntity> implements AxisinfoleService {

    @Autowired
    AxisinfoleDao axisinfoleDao;

    @Override
    public List<AxisinfoleEntity> getLi(int id) {
        List<AxisinfoleEntity> last = axisinfoleDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AxisinfoleEntity> page = this.page(
                new Query<AxisinfoleEntity>().getPage(params),
                new QueryWrapper<AxisinfoleEntity>()
        );

        return new PageUtils(page);
    }

}