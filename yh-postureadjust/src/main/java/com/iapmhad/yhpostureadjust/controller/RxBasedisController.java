package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RxBasedisEntity;
import com.iapmhad.yhpostureadjust.service.RxBasedisService;
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
@RequestMapping("yhpostureadjust/rxbasedis")
public class RxBasedisController {
    @Autowired
    private RxBasedisService rxBasedisService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rxbasedis:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rxBasedisService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rxbasedis:info")
    public R info(@PathVariable("id") Integer id){
		RxBasedisEntity rxBasedis = rxBasedisService.getById(id);

        return R.ok().put("rxBasedis", rxBasedis);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rxbasedis:save")
    public R save(@RequestBody RxBasedisEntity rxBasedis){
		rxBasedisService.save(rxBasedis);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rxbasedis:update")
    public R update(@RequestBody RxBasedisEntity rxBasedis){
		rxBasedisService.updateById(rxBasedis);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rxbasedis:delete")
    public R delete(@RequestBody Integer[] ids){
		rxBasedisService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
