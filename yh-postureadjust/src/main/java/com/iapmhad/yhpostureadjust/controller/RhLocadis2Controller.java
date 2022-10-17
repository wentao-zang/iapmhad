package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RhLocadis1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RhLocadis2Entity;
import com.iapmhad.yhpostureadjust.service.RhLocadis2Service;
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
@RequestMapping("yhpostureadjust/rhlocadis2")
public class RhLocadis2Controller {
    @Autowired
    private RhLocadis2Service rhLocadis2Service;

    @RequestMapping("/getlast/{id}")
    public RhLocadis2Entity getlast(@PathVariable("id") Integer id){
        List<RhLocadis2Entity> last = rhLocadis2Service.getLi(id);
        if(last.size()!=0){
            RhLocadis2Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rhlocadis2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rhLocadis2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rhlocadis2:info")
    public R info(@PathVariable("id") Integer id){
		RhLocadis2Entity rhLocadis2 = rhLocadis2Service.getById(id);

        return R.ok().put("rhLocadis2", rhLocadis2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rhlocadis2:save")
    public R save(@RequestBody RhLocadis2Entity rhLocadis2){
		rhLocadis2Service.save(rhLocadis2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rhlocadis2:update")
    public R update(@RequestBody RhLocadis2Entity rhLocadis2){
		rhLocadis2Service.updateById(rhLocadis2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rhlocadis2:delete")
    public R delete(@RequestBody Integer[] ids){
		rhLocadis2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
