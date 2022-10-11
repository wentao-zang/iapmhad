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

import com.iapmhad.yhpostureadjust.entity.RsLocadis2Entity;
import com.iapmhad.yhpostureadjust.service.RsLocadis2Service;
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
@RequestMapping("yhpostureadjust/rslocadis2")
public class RsLocadis2Controller {
    @Autowired
    private RsLocadis2Service rsLocadis2Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rslocadis2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rsLocadis2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rslocadis2:info")
    public R info(@PathVariable("id") Integer id){
		RsLocadis2Entity rsLocadis2 = rsLocadis2Service.getById(id);

        return R.ok().put("rsLocadis2", rsLocadis2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rslocadis2:save")
    public R save(@RequestBody RsLocadis2Entity rsLocadis2){
		rsLocadis2Service.save(rsLocadis2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rslocadis2:update")
    public R update(@RequestBody RsLocadis2Entity rsLocadis2){
		rsLocadis2Service.updateById(rsLocadis2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rslocadis2:delete")
    public R delete(@RequestBody Integer[] ids){
		rsLocadis2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
