package com.iapmhad.hdymzkjqrxt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.hdymzkjqrxt.dao.XtLogDao;
import com.iapmhad.hdymzkjqrxt.entity.XtLogEntity;
import com.iapmhad.hdymzkjqrxt.service.XtLogService;


@Service("xtLogService")
public class XtLogServiceImpl extends ServiceImpl<XtLogDao, XtLogEntity> implements XtLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<XtLogEntity> page = this.page(
                new Query<XtLogEntity>().getPage(params),
                new QueryWrapper<XtLogEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    XtLogDao XtLogDao;

    @Override
    public List<XtLogEntity> getLi(int id) {
        List<XtLogEntity> li = XtLogDao.getLi(id);
        return li;
    }
    @Override
    public XtLogEntity getLast() {
        XtLogEntity last=XtLogDao.getLast();
        return last;
    }

}