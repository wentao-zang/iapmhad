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

import com.iapmhad.yhpostureadjust.entity.LqLocadisEntity;
import com.iapmhad.yhpostureadjust.service.LqLocadisService;
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
@RequestMapping("yhpostureadjust/lqlocadis")
public class LqLocadisController {
    @Autowired
    private LqLocadisService lqLocadisService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lqlocadis:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lqLocadisService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lqlocadis:info")
    public R info(@PathVariable("id") Integer id){
		LqLocadisEntity lqLocadis = lqLocadisService.getById(id);

        return R.ok().put("lqLocadis", lqLocadis);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lqlocadis:save")
    public R save(@RequestBody LqLocadisEntity lqLocadis){
		lqLocadisService.save(lqLocadis);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lqlocadis:update")
    public R update(@RequestBody LqLocadisEntity lqLocadis){
		lqLocadisService.updateById(lqLocadis);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lqlocadis:delete")
    public R delete(@RequestBody Integer[] ids){
		lqLocadisService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
