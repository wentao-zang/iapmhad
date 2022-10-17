package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RsLocaload2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RsLocastan1Entity;
import com.iapmhad.yhpostureadjust.service.RsLocastan1Service;
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
@RequestMapping("yhpostureadjust/rslocastan1")
public class RsLocastan1Controller {
    @Autowired
    private RsLocastan1Service rsLocastan1Service;

    @RequestMapping("/getlast/{id}")
    public RsLocastan1Entity getlast(@PathVariable("id") Integer id){
        List<RsLocastan1Entity> last = rsLocastan1Service.getLi(id);
        if(last.size()!=0){
            RsLocastan1Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rslocastan1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rsLocastan1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rslocastan1:info")
    public R info(@PathVariable("id") Integer id){
		RsLocastan1Entity rsLocastan1 = rsLocastan1Service.getById(id);

        return R.ok().put("rsLocastan1", rsLocastan1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rslocastan1:save")
    public R save(@RequestBody RsLocastan1Entity rsLocastan1){
		rsLocastan1Service.save(rsLocastan1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rslocastan1:update")
    public R update(@RequestBody RsLocastan1Entity rsLocastan1){
		rsLocastan1Service.updateById(rsLocastan1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rslocastan1:delete")
    public R delete(@RequestBody Integer[] ids){
		rsLocastan1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
