package com.iapmhad.jydbjdj.service.impl;

import com.iapmhad.jydbjdj.dao.JyLocaloadDao;
import com.iapmhad.jydbjdj.entity.JyLocaloadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.jydbjdj.dao.JyLocastanDao;
import com.iapmhad.jydbjdj.entity.JyLocastanEntity;
import com.iapmhad.jydbjdj.service.JyLocastanService;


@Service("jyLocastanService")
public class JyLocastanServiceImpl extends ServiceImpl<JyLocastanDao, JyLocastanEntity> implements JyLocastanService {

    @Autowired
    JyLocastanDao jyLocastanDao;

    @Override
    public List<JyLocastanEntity> getLi(int id) {
        List<JyLocastanEntity> last = jyLocastanDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JyLocastanEntity> page = this.page(
                new Query<JyLocastanEntity>().getPage(params),
                new QueryWrapper<JyLocastanEntity>()
        );

        return new PageUtils(page);
    }

}