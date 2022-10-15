package com.iapmhad.yhmachinedrilling.service.impl;

import com.iapmhad.yhmachinedrilling.dao.AxisinfoDao;
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

import com.iapmhad.yhmachinedrilling.dao.ProductinfoDao;
import com.iapmhad.yhmachinedrilling.entity.ProductinfoEntity;
import com.iapmhad.yhmachinedrilling.service.ProductinfoService;


@Service("productinfoService")
public class ProductinfoServiceImpl extends ServiceImpl<ProductinfoDao, ProductinfoEntity> implements ProductinfoService {

    @Autowired
    ProductinfoDao productinfoDao;

    @Override
    public List<ProductinfoEntity> getLi(int id) {
        List<ProductinfoEntity> last = productinfoDao.getLi(id);
        return last;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductinfoEntity> page = this.page(
                new Query<ProductinfoEntity>().getPage(params),
                new QueryWrapper<ProductinfoEntity>()
        );

        return new PageUtils(page);
    }

}