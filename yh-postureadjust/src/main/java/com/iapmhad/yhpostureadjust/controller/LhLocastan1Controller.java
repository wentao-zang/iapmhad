package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LhLocadis3Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LhLocastan1Entity;
import com.iapmhad.yhpostureadjust.service.LhLocastan1Service;
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
@RequestMapping("yhpostureadjust/lhlocastan1")
public class LhLocastan1Controller {
    @Autowired
    private LhLocastan1Service lhLocastan1Service;

    @RequestMapping("/getlast/{id}")
    public LhLocastan1Entity getlast(@PathVariable("id") Integer id){
        List<LhLocastan1Entity> last = lhLocastan1Service.getLi(id);
        if(last.size()!=0){
            LhLocastan1Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lhlocastan1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lhLocastan1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lhlocastan1:info")
    public R info(@PathVariable("id") Integer id){
		LhLocastan1Entity lhLocastan1 = lhLocastan1Service.getById(id);

        return R.ok().put("lhLocastan1", lhLocastan1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lhlocastan1:save")
    public R save(@RequestBody LhLocastan1Entity lhLocastan1){
		lhLocastan1Service.save(lhLocastan1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lhlocastan1:update")
    public R update(@RequestBody LhLocastan1Entity lhLocastan1){
		lhLocastan1Service.updateById(lhLocastan1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lhlocastan1:delete")
    public R delete(@RequestBody Integer[] ids){
		lhLocastan1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
