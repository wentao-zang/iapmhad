package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RxLocaload2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RxLocastan1Entity;
import com.iapmhad.yhpostureadjust.service.RxLocastan1Service;
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
@RequestMapping("yhpostureadjust/rxlocastan1")
public class RxLocastan1Controller {
    @Autowired
    private RxLocastan1Service rxLocastan1Service;

    @RequestMapping("/getlast/{id}")
    public RxLocastan1Entity getlast(@PathVariable("id") Integer id){
        List<RxLocastan1Entity> last = rxLocastan1Service.getLi(id);
        if(last.size()!=0){
            RxLocastan1Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rxlocastan1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rxLocastan1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rxlocastan1:info")
    public R info(@PathVariable("id") Integer id){
		RxLocastan1Entity rxLocastan1 = rxLocastan1Service.getById(id);

        return R.ok().put("rxLocastan1", rxLocastan1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rxlocastan1:save")
    public R save(@RequestBody RxLocastan1Entity rxLocastan1){
		rxLocastan1Service.save(rxLocastan1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rxlocastan1:update")
    public R update(@RequestBody RxLocastan1Entity rxLocastan1){
		rxLocastan1Service.updateById(rxLocastan1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rxlocastan1:delete")
    public R delete(@RequestBody Integer[] ids){
		rxLocastan1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
