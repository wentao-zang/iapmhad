package com.iapmhad.jydbjdj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.jydbjdj.dao.JyLocadisDao;
import com.iapmhad.jydbjdj.entity.JyLocadisEntity;
import com.iapmhad.jydbjdj.service.JyLocadisService;


@Service("jyLocadisService")
public class JyLocadisServiceImpl extends ServiceImpl<JyLocadisDao, JyLocadisEntity> implements JyLocadisService {

    @Autowired
    JyLocadisDao jyLocadisDao;

    @Override
    public List<JyLocadisEntity> getLi(int id) {
        List<JyLocadisEntity> last = jyLocadisDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JyLocadisEntity> page = this.page(
                new Query<JyLocadisEntity>().getPage(params),
                new QueryWrapper<JyLocadisEntity>()
        );

        return new PageUtils(page);
    }

}