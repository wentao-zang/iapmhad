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

import com.iapmhad.yhpostureadjust.entity.RsLocaload2Entity;
import com.iapmhad.yhpostureadjust.service.RsLocaload2Service;
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
@RequestMapping("yhpostureadjust/rslocaload2")
public class RsLocaload2Controller {
    @Autowired
    private RsLocaload2Service rsLocaload2Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rslocaload2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rsLocaload2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rslocaload2:info")
    public R info(@PathVariable("id") Integer id){
		RsLocaload2Entity rsLocaload2 = rsLocaload2Service.getById(id);

        return R.ok().put("rsLocaload2", rsLocaload2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rslocaload2:save")
    public R save(@RequestBody RsLocaload2Entity rsLocaload2){
		rsLocaload2Service.save(rsLocaload2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rslocaload2:update")
    public R update(@RequestBody RsLocaload2Entity rsLocaload2){
		rsLocaload2Service.updateById(rsLocaload2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rslocaload2:delete")
    public R delete(@RequestBody Integer[] ids){
		rsLocaload2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
