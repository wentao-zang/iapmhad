package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RxLocastan1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RxLocastan2Entity;
import com.iapmhad.yhpostureadjust.service.RxLocastan2Service;
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
@RequestMapping("yhpostureadjust/rxlocastan2")
public class RxLocastan2Controller {
    @Autowired
    private RxLocastan2Service rxLocastan2Service;

    @RequestMapping("/getlast/{id}")
    public RxLocastan2Entity getlast(@PathVariable("id") Integer id){
        List<RxLocastan2Entity> last = rxLocastan2Service.getLi(id);
        if(last.size()!=0){
            RxLocastan2Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rxlocastan2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rxLocastan2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rxlocastan2:info")
    public R info(@PathVariable("id") Integer id){
		RxLocastan2Entity rxLocastan2 = rxLocastan2Service.getById(id);

        return R.ok().put("rxLocastan2", rxLocastan2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rxlocastan2:save")
    public R save(@RequestBody RxLocastan2Entity rxLocastan2){
		rxLocastan2Service.save(rxLocastan2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rxlocastan2:update")
    public R update(@RequestBody RxLocastan2Entity rxLocastan2){
		rxLocastan2Service.updateById(rxLocastan2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rxlocastan2:delete")
    public R delete(@RequestBody Integer[] ids){
		rxLocastan2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
