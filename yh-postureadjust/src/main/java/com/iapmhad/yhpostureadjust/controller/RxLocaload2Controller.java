package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RxLocaload1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RxLocaload2Entity;
import com.iapmhad.yhpostureadjust.service.RxLocaload2Service;
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
@RequestMapping("yhpostureadjust/rxlocaload2")
public class RxLocaload2Controller {
    @Autowired
    private RxLocaload2Service rxLocaload2Service;

    @RequestMapping("/getlast/{id}")
    public RxLocaload2Entity getlast(@PathVariable("id") Integer id){
        List<RxLocaload2Entity> last = rxLocaload2Service.getLi(id);
        if(last.size()!=0){
            RxLocaload2Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rxlocaload2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rxLocaload2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rxlocaload2:info")
    public R info(@PathVariable("id") Integer id){
		RxLocaload2Entity rxLocaload2 = rxLocaload2Service.getById(id);

        return R.ok().put("rxLocaload2", rxLocaload2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rxlocaload2:save")
    public R save(@RequestBody RxLocaload2Entity rxLocaload2){
		rxLocaload2Service.save(rxLocaload2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rxlocaload2:update")
    public R update(@RequestBody RxLocaload2Entity rxLocaload2){
		rxLocaload2Service.updateById(rxLocaload2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rxlocaload2:delete")
    public R delete(@RequestBody Integer[] ids){
		rxLocaload2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
