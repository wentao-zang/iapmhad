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

import com.iapmhad.yhpostureadjust.entity.LsLocaload1Entity;
import com.iapmhad.yhpostureadjust.service.LsLocaload1Service;
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
@RequestMapping("yhpostureadjust/lslocaload1")
public class LsLocaload1Controller {
    @Autowired
    private LsLocaload1Service lsLocaload1Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lslocaload1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lsLocaload1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lslocaload1:info")
    public R info(@PathVariable("id") Integer id){
		LsLocaload1Entity lsLocaload1 = lsLocaload1Service.getById(id);

        return R.ok().put("lsLocaload1", lsLocaload1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lslocaload1:save")
    public R save(@RequestBody LsLocaload1Entity lsLocaload1){
		lsLocaload1Service.save(lsLocaload1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lslocaload1:update")
    public R update(@RequestBody LsLocaload1Entity lsLocaload1){
		lsLocaload1Service.updateById(lsLocaload1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lslocaload1:delete")
    public R delete(@RequestBody Integer[] ids){
		lsLocaload1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
