package com.iapmhad.yhmachinedrilling.dao;

import com.iapmhad.yhmachinedrilling.entity.AxisinfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iapmhad.yhmachinedrilling.entity.ProductinfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:15:34
 */
@Mapper
public interface AxisinfoDao extends BaseMapper<AxisinfoEntity> {
    List<AxisinfoEntity> getLi(int id);
	
}
