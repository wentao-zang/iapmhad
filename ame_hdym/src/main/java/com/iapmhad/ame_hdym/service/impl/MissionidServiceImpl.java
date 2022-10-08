package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.MissionidDao;
import com.iapmhad.ame_hdym.entity.MissionidEntity;
import com.iapmhad.ame_hdym.service.MissionidService;


@Service("missionidService")
public class MissionidServiceImpl extends ServiceImpl<MissionidDao, MissionidEntity> implements MissionidService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MissionidEntity> page = this.page(
                new Query<MissionidEntity>().getPage(params),
                new QueryWrapper<MissionidEntity>()
        );

        return new PageUtils(page);
    }

}