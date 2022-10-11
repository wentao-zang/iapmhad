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

import com.iapmhad.yhpostureadjust.entity.LsLocadis1Entity;
import com.iapmhad.yhpostureadjust.service.LsLocadis1Service;
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
@RequestMapping("yhpostureadjust/lslocadis1")
public class LsLocadis1Controller {
    @Autowired
    private LsLocadis1Service lsLocadis1Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    ////@RequiresPermissions("yhpostureadjust:lslocadis1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lsLocadis1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    ////@RequiresPermissions("yhpostureadjust:lslocadis1:info")
    public R info(@PathVariable("id") Integer id){
		LsLocadis1Entity lsLocadis1 = lsLocadis1Service.getById(id);

        return R.ok().put("lsLocadis1", lsLocadis1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lslocadis1:save")
    public R save(@RequestBody LsLocadis1Entity lsLocadis1){
		lsLocadis1Service.save(lsLocadis1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lslocadis1:update")
    public R update(@RequestBody LsLocadis1Entity lsLocadis1){
		lsLocadis1Service.updateById(lsLocadis1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lslocadis1:delete")
    public R delete(@RequestBody Integer[] ids){
		lsLocadis1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
