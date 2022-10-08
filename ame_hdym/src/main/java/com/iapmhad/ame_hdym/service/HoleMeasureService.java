package com.iapmhad.ame_hdym.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.ame_hdym.entity.HoleMeasureEntity;

import java.util.List;

/**
 * 
 *
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
public interface HoleMeasureService extends IService<HoleMeasureEntity> {
    public List<HoleMeasureEntity> getHoleMeasure(String aircraftid, String flightid, String productnum, Double holedia);
    public List<HoleMeasureEntity> getHoleMea(Double holedia, String time);
    public Object[] strrefine(String args);
    HoleMeasureEntity getLast();
    List<HoleMeasureEntity> getChongJi(String strtime);
    List<HoleMeasureEntity> getLi(int id);
}

