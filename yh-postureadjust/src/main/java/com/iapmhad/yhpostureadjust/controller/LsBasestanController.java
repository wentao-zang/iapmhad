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

import com.iapmhad.yhpostureadjust.entity.LsBasestanEntity;
import com.iapmhad.yhpostureadjust.service.LsBasestanService;
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
@RequestMapping("yhpostureadjust/lsbasestan")
public class LsBasestanController {
    @Autowired
    private LsBasestanService lsBasestanService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lsbasestan:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lsBasestanService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lsbasestan:info")
    public R info(@PathVariable("id") Integer id){
		LsBasestanEntity lsBasestan = lsBasestanService.getById(id);

        return R.ok().put("lsBasestan", lsBasestan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lsbasestan:save")
    public R save(@RequestBody LsBasestanEntity lsBasestan){
		lsBasestanService.save(lsBasestan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lsbasestan:update")
    public R update(@RequestBody LsBasestanEntity lsBasestan){
		lsBasestanService.updateById(lsBasestan);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lsbasestan:delete")
    public R delete(@RequestBody Integer[] ids){
		lsBasestanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
