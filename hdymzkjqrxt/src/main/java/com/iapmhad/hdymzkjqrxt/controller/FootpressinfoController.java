package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.FootpressinfoEntity;
import com.iapmhad.hdymzkjqrxt.service.FootpressinfoService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;
import org.springframework.cloud.context.config.annotation.RefreshScope;




/**
 * 
 *
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
@RefreshScope
@RestController
@RequestMapping("hdymzkjqrxt/footpressinfo")
public class FootpressinfoController {
    @Autowired
    private FootpressinfoService footpressinfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hdymzkjqrxt:footpressinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = footpressinfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<FootpressinfoEntity> getLi(@PathVariable("id") Integer id) {
        List<FootpressinfoEntity> list = footpressinfoService.getLi(id);
        if(list.size()>100) {
            list = list.subList(list.size() - 100,list.size());
        }
        return list;
    }
    /*
     *获取最后一个的数据
     *
     * */
    @RequestMapping("/getLast")
    public FootpressinfoEntity getLast(){
        FootpressinfoEntity Footpressinfo = footpressinfoService.getLast();
        return  Footpressinfo;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hdymzkjqrxt:footpressinfo:info")
    public R info(@PathVariable("id") Integer id){
		FootpressinfoEntity footpressinfo = footpressinfoService.getById(id);

        return R.ok().put("footpressinfo", footpressinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hdymzkjqrxt:footpressinfo:save")
    public R save(@RequestBody FootpressinfoEntity footpressinfo){
		footpressinfoService.save(footpressinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hdymzkjqrxt:footpressinfo:update")
    public R update(@RequestBody FootpressinfoEntity footpressinfo){
		footpressinfoService.updateById(footpressinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hdymzkjqrxt:footpressinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		footpressinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
