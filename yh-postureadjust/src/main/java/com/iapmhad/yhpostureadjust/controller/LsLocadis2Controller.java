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

import com.iapmhad.yhpostureadjust.entity.LsLocadis2Entity;
import com.iapmhad.yhpostureadjust.service.LsLocadis2Service;
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
@RequestMapping("yhpostureadjust/lslocadis2")
public class LsLocadis2Controller {
    @Autowired
    private LsLocadis2Service lsLocadis2Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lslocadis2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lsLocadis2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lslocadis2:info")
    public R info(@PathVariable("id") Integer id){
		LsLocadis2Entity lsLocadis2 = lsLocadis2Service.getById(id);

        return R.ok().put("lsLocadis2", lsLocadis2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lslocadis2:save")
    public R save(@RequestBody LsLocadis2Entity lsLocadis2){
		lsLocadis2Service.save(lsLocadis2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lslocadis2:update")
    public R update(@RequestBody LsLocadis2Entity lsLocadis2){
		lsLocadis2Service.updateById(lsLocadis2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lslocadis2:delete")
    public R delete(@RequestBody Integer[] ids){
		lsLocadis2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
