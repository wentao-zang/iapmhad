package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RsBasedisEntity;
import com.iapmhad.yhpostureadjust.service.RsBasedisService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:11:17
 */
@RestController
@RequestMapping("yhpostureadjust/rsbasedis")
public class RsBasedisController {
    @Autowired
    private RsBasedisService rsBasedisService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rsbasedis:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rsBasedisService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rsbasedis:info")
    public R info(@PathVariable("id") Integer id){
		RsBasedisEntity rsBasedis = rsBasedisService.getById(id);

        return R.ok().put("rsBasedis", rsBasedis);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rsbasedis:save")
    public R save(@RequestBody RsBasedisEntity rsBasedis){
		rsBasedisService.save(rsBasedis);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rsbasedis:update")
    public R update(@RequestBody RsBasedisEntity rsBasedis){
		rsBasedisService.updateById(rsBasedis);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rsbasedis:delete")
    public R delete(@RequestBody Integer[] ids){
		rsBasedisService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
