package com.iapmhad.hdymzkjqrxt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.hdymzkjqrxt.entity.CpProductEntity;
import com.iapmhad.hdymzkjqrxt.entity.HoleMeasureEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 *
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
public interface HoleMeasureService extends IService<HoleMeasureEntity> {
    public List<HoleMeasureEntity> getHoleMeasure(String aircraftid,String flightid,String productnum,Double holedia);
    public List<HoleMeasureEntity> getHoleMea(Double holedia, String time);
    public Object[] strrefine(String args);
    HoleMeasureEntity getLast();
}

