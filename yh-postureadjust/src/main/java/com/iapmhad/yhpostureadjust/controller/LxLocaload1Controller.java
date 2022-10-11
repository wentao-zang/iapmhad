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

import com.iapmhad.yhpostureadjust.entity.LxLocaload1Entity;
import com.iapmhad.yhpostureadjust.service.LxLocaload1Service;
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
@RequestMapping("yhpostureadjust/lxlocaload1")
public class LxLocaload1Controller {
    @Autowired
    private LxLocaload1Service lxLocaload1Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lxlocaload1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lxLocaload1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lxlocaload1:info")
    public R info(@PathVariable("id") Integer id){
		LxLocaload1Entity lxLocaload1 = lxLocaload1Service.getById(id);

        return R.ok().put("lxLocaload1", lxLocaload1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lxlocaload1:save")
    public R save(@RequestBody LxLocaload1Entity lxLocaload1){
		lxLocaload1Service.save(lxLocaload1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lxlocaload1:update")
    public R update(@RequestBody LxLocaload1Entity lxLocaload1){
		lxLocaload1Service.updateById(lxLocaload1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lxlocaload1:delete")
    public R delete(@RequestBody Integer[] ids){
		lxLocaload1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
