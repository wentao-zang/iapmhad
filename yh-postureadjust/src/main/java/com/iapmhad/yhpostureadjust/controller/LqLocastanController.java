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

import com.iapmhad.yhpostureadjust.entity.LqLocastanEntity;
import com.iapmhad.yhpostureadjust.service.LqLocastanService;
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
@RequestMapping("yhpostureadjust/lqlocastan")
public class LqLocastanController {
    @Autowired
    private LqLocastanService lqLocastanService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lqlocastan:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lqLocastanService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lqlocastan:info")
    public R info(@PathVariable("id") Integer id){
		LqLocastanEntity lqLocastan = lqLocastanService.getById(id);

        return R.ok().put("lqLocastan", lqLocastan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lqlocastan:save")
    public R save(@RequestBody LqLocastanEntity lqLocastan){
		lqLocastanService.save(lqLocastan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lqlocastan:update")
    public R update(@RequestBody LqLocastanEntity lqLocastan){
		lqLocastanService.updateById(lqLocastan);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lqlocastan:delete")
    public R delete(@RequestBody Integer[] ids){
		lqLocastanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
