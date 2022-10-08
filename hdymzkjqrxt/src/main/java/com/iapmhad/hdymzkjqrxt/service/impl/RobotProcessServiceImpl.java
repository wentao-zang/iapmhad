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

import com.iapmhad.hdymzkjqrxt.dao.RobotProcessDao;
import com.iapmhad.hdymzkjqrxt.entity.RobotProcessEntity;
import com.iapmhad.hdymzkjqrxt.service.RobotProcessService;


@Service("robotProcessService")
public class RobotProcessServiceImpl extends ServiceImpl<RobotProcessDao, RobotProcessEntity> implements RobotProcessService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RobotProcessEntity> page = this.page(
                new Query<RobotProcessEntity>().getPage(params),
                new QueryWrapper<RobotProcessEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    RobotProcessDao RobotProcessDao;

    @Override
    public List<RobotProcessEntity> getLi(int id) {
        List<RobotProcessEntity> li = RobotProcessDao.getLi(id);
        return li;
    }
    @Override
    public RobotProcessEntity getLast() {
        RobotProcessEntity last=RobotProcessDao.getLast();
        return last;
    }

}