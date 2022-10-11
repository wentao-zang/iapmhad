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

import com.iapmhad.yhpostureadjust.entity.LxBasedisEntity;
import com.iapmhad.yhpostureadjust.service.LxBasedisService;
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
@RequestMapping("yhpostureadjust/lxbasedis")
public class LxBasedisController {
    @Autowired
    private LxBasedisService lxBasedisService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lxbasedis:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lxBasedisService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lxbasedis:info")
    public R info(@PathVariable("id") Integer id){
		LxBasedisEntity lxBasedis = lxBasedisService.getById(id);

        return R.ok().put("lxBasedis", lxBasedis);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lxbasedis:save")
    public R save(@RequestBody LxBasedisEntity lxBasedis){
		lxBasedisService.save(lxBasedis);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lxbasedis:update")
    public R update(@RequestBody LxBasedisEntity lxBasedis){
		lxBasedisService.updateById(lxBasedis);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lxbasedis:delete")
    public R delete(@RequestBody Integer[] ids){
		lxBasedisService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
