package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RhLocastan1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RhLocastan2Entity;
import com.iapmhad.yhpostureadjust.service.RhLocastan2Service;
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
@RequestMapping("yhpostureadjust/rhlocastan2")
public class RhLocastan2Controller {
    @Autowired
    private RhLocastan2Service rhLocastan2Service;

    @RequestMapping("/getlast/{id}")
    public RhLocastan2Entity getlast(@PathVariable("id") Integer id){
        List<RhLocastan2Entity> last = rhLocastan2Service.getLi(id);
        if(last.size()!=0){
            RhLocastan2Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rhlocastan2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rhLocastan2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rhlocastan2:info")
    public R info(@PathVariable("id") Integer id){
		RhLocastan2Entity rhLocastan2 = rhLocastan2Service.getById(id);

        return R.ok().put("rhLocastan2", rhLocastan2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rhlocastan2:save")
    public R save(@RequestBody RhLocastan2Entity rhLocastan2){
		rhLocastan2Service.save(rhLocastan2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rhlocastan2:update")
    public R update(@RequestBody RhLocastan2Entity rhLocastan2){
		rhLocastan2Service.updateById(rhLocastan2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rhlocastan2:delete")
    public R delete(@RequestBody Integer[] ids){
		rhLocastan2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
