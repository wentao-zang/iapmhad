package com.iapmhad.ame_hdym.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.ame_hdym.entity.SpinfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-09-15 11:02:30
 */
public interface SpinfoService extends IService<SpinfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

