package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RhLocadis3Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RhLocastan1Entity;
import com.iapmhad.yhpostureadjust.service.RhLocastan1Service;
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
@RequestMapping("yhpostureadjust/rhlocastan1")
public class RhLocastan1Controller {
    @Autowired
    private RhLocastan1Service rhLocastan1Service;

    @RequestMapping("/getlast/{id}")
    public RhLocastan1Entity getlast(@PathVariable("id") Integer id){
        List<RhLocastan1Entity> last = rhLocastan1Service.getLi(id);
        if(last.size()!=0){
            RhLocastan1Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rhlocastan1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rhLocastan1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rhlocastan1:info")
    public R info(@PathVariable("id") Integer id){
		RhLocastan1Entity rhLocastan1 = rhLocastan1Service.getById(id);

        return R.ok().put("rhLocastan1", rhLocastan1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rhlocastan1:save")
    public R save(@RequestBody RhLocastan1Entity rhLocastan1){
		rhLocastan1Service.save(rhLocastan1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rhlocastan1:update")
    public R update(@RequestBody RhLocastan1Entity rhLocastan1){
		rhLocastan1Service.updateById(rhLocastan1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rhlocastan1:delete")
    public R delete(@RequestBody Integer[] ids){
		rhLocastan1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
