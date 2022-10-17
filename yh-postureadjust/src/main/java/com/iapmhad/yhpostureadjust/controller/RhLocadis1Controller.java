package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RhfLocastanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RhLocadis1Entity;
import com.iapmhad.yhpostureadjust.service.RhLocadis1Service;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-17 18:27:31
 */
@RestController
@RequestMapping("yhpostureadjust/rhlocadis1")
public class RhLocadis1Controller {
    @Autowired
    private RhLocadis1Service rhLocadis1Service;

    @RequestMapping("/getlast/{id}")
    public RhLocadis1Entity getlast(@PathVariable("id") Integer id){
        List<RhLocadis1Entity> last = rhLocadis1Service.getLi(id);
        if(last.size()!=0){
            RhLocadis1Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rhlocadis1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rhLocadis1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rhlocadis1:info")
    public R info(@PathVariable("id") Integer id){
		RhLocadis1Entity rhLocadis1 = rhLocadis1Service.getById(id);

        return R.ok().put("rhLocadis1", rhLocadis1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rhlocadis1:save")
    public R save(@RequestBody RhLocadis1Entity rhLocadis1){
		rhLocadis1Service.save(rhLocadis1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rhlocadis1:update")
    public R update(@RequestBody RhLocadis1Entity rhLocadis1){
		rhLocadis1Service.updateById(rhLocadis1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rhlocadis1:delete")
    public R delete(@RequestBody Integer[] ids){
		rhLocadis1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
