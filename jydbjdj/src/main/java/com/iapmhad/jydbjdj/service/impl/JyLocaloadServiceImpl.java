package com.iapmhad.jydbjdj.service.impl;

import com.iapmhad.jydbjdj.dao.JyLocadisDao;
import com.iapmhad.jydbjdj.entity.JyLocadisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.Query;

import com.iapmhad.jydbjdj.dao.JyLocaloadDao;
import com.iapmhad.jydbjdj.entity.JyLocaloadEntity;
import com.iapmhad.jydbjdj.service.JyLocaloadService;


@Service("jyLocaloadService")
public class JyLocaloadServiceImpl extends ServiceImpl<JyLocaloadDao, JyLocaloadEntity> implements JyLocaloadService {

    @Autowired
    JyLocaloadDao jyLocaloadDao;

    @Override
    public List<JyLocaloadEntity> getLi(int id) {
        List<JyLocaloadEntity> last = jyLocaloadDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JyLocaloadEntity> page = this.page(
                new Query<JyLocaloadEntity>().getPage(params),
                new QueryWrapper<JyLocaloadEntity>()
        );

        return new PageUtils(page);
    }

}