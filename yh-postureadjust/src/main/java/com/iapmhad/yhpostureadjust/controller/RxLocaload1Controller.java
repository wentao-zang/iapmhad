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

import com.iapmhad.yhpostureadjust.entity.RxLocaload1Entity;
import com.iapmhad.yhpostureadjust.service.RxLocaload1Service;
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
@RequestMapping("yhpostureadjust/rxlocaload1")
public class RxLocaload1Controller {
    @Autowired
    private RxLocaload1Service rxLocaload1Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rxlocaload1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rxLocaload1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rxlocaload1:info")
    public R info(@PathVariable("id") Integer id){
		RxLocaload1Entity rxLocaload1 = rxLocaload1Service.getById(id);

        return R.ok().put("rxLocaload1", rxLocaload1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rxlocaload1:save")
    public R save(@RequestBody RxLocaload1Entity rxLocaload1){
		rxLocaload1Service.save(rxLocaload1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rxlocaload1:update")
    public R update(@RequestBody RxLocaload1Entity rxLocaload1){
		rxLocaload1Service.updateById(rxLocaload1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rxlocaload1:delete")
    public R delete(@RequestBody Integer[] ids){
		rxLocaload1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
