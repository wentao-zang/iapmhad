package com.iapmhad.yhpostureadjust.dao;

import com.iapmhad.yhpostureadjust.entity.LxLocadis2Entity;
import com.iapmhad.yhpostureadjust.entity.LxLocaload1Entity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:11:17
 */
@Mapper
public interface LxLocaload1Dao extends BaseMapper<LxLocaload1Entity> {
    List<LxLocaload1Entity> getLi(int id);
}
