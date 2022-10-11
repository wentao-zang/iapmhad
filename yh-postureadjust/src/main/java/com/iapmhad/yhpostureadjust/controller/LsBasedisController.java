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

import com.iapmhad.yhpostureadjust.entity.LsBasedisEntity;
import com.iapmhad.yhpostureadjust.service.LsBasedisService;
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
@RequestMapping("yhpostureadjust/lsbasedis")
public class LsBasedisController {
    @Autowired
    private LsBasedisService lsBasedisService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lsbasedis:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lsBasedisService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lsbasedis:info")
    public R info(@PathVariable("id") Integer id){
		LsBasedisEntity lsBasedis = lsBasedisService.getById(id);

        return R.ok().put("lsBasedis", lsBasedis);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lsbasedis:save")
    public R save(@RequestBody LsBasedisEntity lsBasedis){
		lsBasedisService.save(lsBasedis);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lsbasedis:update")
    public R update(@RequestBody LsBasedisEntity lsBasedis){
		lsBasedisService.updateById(lsBasedis);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lsbasedis:delete")
    public R delete(@RequestBody Integer[] ids){
		lsBasedisService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
