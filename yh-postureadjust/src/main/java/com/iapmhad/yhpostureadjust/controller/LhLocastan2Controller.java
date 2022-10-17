package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LhLocastan1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LhLocastan2Entity;
import com.iapmhad.yhpostureadjust.service.LhLocastan2Service;
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
@RequestMapping("yhpostureadjust/lhlocastan2")
public class LhLocastan2Controller {
    @Autowired
    private LhLocastan2Service lhLocastan2Service;

    @RequestMapping("/getlast/{id}")
    public LhLocastan2Entity getlast(@PathVariable("id") Integer id){
        List<LhLocastan2Entity> last = lhLocastan2Service.getLi(id);
        if(last.size()!=0){
            LhLocastan2Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lhlocastan2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lhLocastan2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lhlocastan2:info")
    public R info(@PathVariable("id") Integer id){
		LhLocastan2Entity lhLocastan2 = lhLocastan2Service.getById(id);

        return R.ok().put("lhLocastan2", lhLocastan2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lhlocastan2:save")
    public R save(@RequestBody LhLocastan2Entity lhLocastan2){
		lhLocastan2Service.save(lhLocastan2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lhlocastan2:update")
    public R update(@RequestBody LhLocastan2Entity lhLocastan2){
		lhLocastan2Service.updateById(lhLocastan2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lhlocastan2:delete")
    public R delete(@RequestBody Integer[] ids){
		lhLocastan2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
