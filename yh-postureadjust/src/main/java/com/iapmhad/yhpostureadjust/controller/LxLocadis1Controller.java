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

import com.iapmhad.yhpostureadjust.entity.LxLocadis1Entity;
import com.iapmhad.yhpostureadjust.service.LxLocadis1Service;
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
@RequestMapping("yhpostureadjust/lxlocadis1")
public class LxLocadis1Controller {
    @Autowired
    private LxLocadis1Service lxLocadis1Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lxlocadis1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lxLocadis1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lxlocadis1:info")
    public R info(@PathVariable("id") Integer id){
		LxLocadis1Entity lxLocadis1 = lxLocadis1Service.getById(id);

        return R.ok().put("lxLocadis1", lxLocadis1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lxlocadis1:save")
    public R save(@RequestBody LxLocadis1Entity lxLocadis1){
		lxLocadis1Service.save(lxLocadis1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lxlocadis1:update")
    public R update(@RequestBody LxLocadis1Entity lxLocadis1){
		lxLocadis1Service.updateById(lxLocadis1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lxlocadis1:delete")
    public R delete(@RequestBody Integer[] ids){
		lxLocadis1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
