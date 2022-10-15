package com.iapmhad.yhmachinedrilling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.yhmachinedrilling.entity.AxisinfoEntity;
import com.iapmhad.yhmachinedrilling.entity.SpinfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:15:34
 */
public interface SpinfoService extends IService<SpinfoEntity> {
    List<SpinfoEntity> getLi(int id);
    PageUtils queryPage(Map<String, Object> params);
}

