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

import com.iapmhad.yhpostureadjust.entity.LsLocastan1Entity;
import com.iapmhad.yhpostureadjust.service.LsLocastan1Service;
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
@RequestMapping("yhpostureadjust/lslocastan1")
public class LsLocastan1Controller {
    @Autowired
    private LsLocastan1Service lsLocastan1Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lslocastan1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lsLocastan1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lslocastan1:info")
    public R info(@PathVariable("id") Integer id){
		LsLocastan1Entity lsLocastan1 = lsLocastan1Service.getById(id);

        return R.ok().put("lsLocastan1", lsLocastan1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lslocastan1:save")
    public R save(@RequestBody LsLocastan1Entity lsLocastan1){
		lsLocastan1Service.save(lsLocastan1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lslocastan1:update")
    public R update(@RequestBody LsLocastan1Entity lsLocastan1){
		lsLocastan1Service.updateById(lsLocastan1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lslocastan1:delete")
    public R delete(@RequestBody Integer[] ids){
		lsLocastan1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
