package com.iapmhad.hdymzkjqrxt.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iapmhad.hdymzkjqrxt.entity.CpProductEntity;
import com.iapmhad.hdymzkjqrxt.entity.HoleMeasureEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
@Mapper
public interface HoleMeasuretDao extends BaseMapper<HoleMeasureEntity> {
    public List<HoleMeasureEntity> getHoleMeasure(String aircraftid,String flightid,String productnum,Double holedia);
    public List<HoleMeasureEntity> getHoleMea(Double holedia, String time);
    public HoleMeasureEntity getLast();
}
