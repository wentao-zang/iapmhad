package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RhfLocadisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RhfLocastanEntity;
import com.iapmhad.yhpostureadjust.service.RhfLocastanService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-17 18:27:30
 */
@RestController
@RequestMapping("yhpostureadjust/rhflocastan")
public class RhfLocastanController {
    @Autowired
    private RhfLocastanService rhfLocastanService;

    @RequestMapping("/getlast/{id}")
    public RhfLocastanEntity getlast(@PathVariable("id") Integer id){
        List<RhfLocastanEntity> last = rhfLocastanService.getLi(id);
        if(last.size()!=0){
            RhfLocastanEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rhflocastan:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rhfLocastanService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rhflocastan:info")
    public R info(@PathVariable("id") Integer id){
		RhfLocastanEntity rhfLocastan = rhfLocastanService.getById(id);

        return R.ok().put("rhfLocastan", rhfLocastan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rhflocastan:save")
    public R save(@RequestBody RhfLocastanEntity rhfLocastan){
		rhfLocastanService.save(rhfLocastan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rhflocastan:update")
    public R update(@RequestBody RhfLocastanEntity rhfLocastan){
		rhfLocastanService.updateById(rhfLocastan);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rhflocastan:delete")
    public R delete(@RequestBody Integer[] ids){
		rhfLocastanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
