package com.iapmhad.ame_hdym.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.ame_hdym.dao.MachineDao;
import com.iapmhad.ame_hdym.entity.MachineEntity;
import com.iapmhad.ame_hdym.service.MachineService;


@Service("machineService")
public class MachineServiceImpl extends ServiceImpl<MachineDao, MachineEntity> implements MachineService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MachineEntity> page = this.page(
                new Query<MachineEntity>().getPage(params),
                new QueryWrapper<MachineEntity>()
        );

        return new PageUtils(page);
    }

}