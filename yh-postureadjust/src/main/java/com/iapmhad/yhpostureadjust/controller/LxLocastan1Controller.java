package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LsLocadis1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LxLocastan1Entity;
import com.iapmhad.yhpostureadjust.service.LxLocastan1Service;
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
@RequestMapping("yhpostureadjust/lxlocastan1")
public class LxLocastan1Controller {
    @Autowired
    private LxLocastan1Service lxLocastan1Service;

    @RequestMapping("/getlast/{id}")
    public LxLocastan1Entity getlast(@PathVariable("id") Integer id){
        List<LxLocastan1Entity> last = lxLocastan1Service.getLi(id);
        if(last.size()!=0){
            LxLocastan1Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lxlocastan1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lxLocastan1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lxlocastan1:info")
    public R info(@PathVariable("id") Integer id){
		LxLocastan1Entity lxLocastan1 = lxLocastan1Service.getById(id);

        return R.ok().put("lxLocastan1", lxLocastan1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lxlocastan1:save")
    public R save(@RequestBody LxLocastan1Entity lxLocastan1){
		lxLocastan1Service.save(lxLocastan1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lxlocastan1:update")
    public R update(@RequestBody LxLocastan1Entity lxLocastan1){
		lxLocastan1Service.updateById(lxLocastan1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lxlocastan1:delete")
    public R delete(@RequestBody Integer[] ids){
		lxLocastan1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
