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

import com.iapmhad.yhpostureadjust.entity.RsLocastan2Entity;
import com.iapmhad.yhpostureadjust.service.RsLocastan2Service;
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
@RequestMapping("yhpostureadjust/rslocastan2")
public class RsLocastan2Controller {
    @Autowired
    private RsLocastan2Service rsLocastan2Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rslocastan2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rsLocastan2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rslocastan2:info")
    public R info(@PathVariable("id") Integer id){
		RsLocastan2Entity rsLocastan2 = rsLocastan2Service.getById(id);

        return R.ok().put("rsLocastan2", rsLocastan2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rslocastan2:save")
    public R save(@RequestBody RsLocastan2Entity rsLocastan2){
		rsLocastan2Service.save(rsLocastan2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rslocastan2:update")
    public R update(@RequestBody RsLocastan2Entity rsLocastan2){
		rsLocastan2Service.updateById(rsLocastan2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rslocastan2:delete")
    public R delete(@RequestBody Integer[] ids){
		rsLocastan2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
