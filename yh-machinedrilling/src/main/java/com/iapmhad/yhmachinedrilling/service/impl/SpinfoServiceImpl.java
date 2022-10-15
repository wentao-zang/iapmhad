package com.iapmhad.yhmachinedrilling.service.impl;

import com.iapmhad.yhmachinedrilling.entity.AxisinfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.yhmachinedrilling.dao.SpinfoDao;
import com.iapmhad.yhmachinedrilling.entity.SpinfoEntity;
import com.iapmhad.yhmachinedrilling.service.SpinfoService;


@Service("spinfoService")
public class SpinfoServiceImpl extends ServiceImpl<SpinfoDao, SpinfoEntity> implements SpinfoService {

    @Autowired
    SpinfoDao spinfoDao;

    @Override
    public List<SpinfoEntity> getLi(int id) {
        List<SpinfoEntity> last = spinfoDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpinfoEntity> page = this.page(
                new Query<SpinfoEntity>().getPage(params),
                new QueryWrapper<SpinfoEntity>()
        );

        return new PageUtils(page);
    }

}