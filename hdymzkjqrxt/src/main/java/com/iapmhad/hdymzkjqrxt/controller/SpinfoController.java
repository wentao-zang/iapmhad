package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.SpinfoEntity;
import com.iapmhad.hdymzkjqrxt.service.SpinfoService;
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
@RequestMapping("hdymzkjqrxt/spinfo")
public class SpinfoController {
    @Autowired
    private SpinfoService spinfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    ////@RequiresPermissions("hdymzkjqrxt:spinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = spinfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<SpinfoEntity> getLi(@PathVariable("id") Integer id) {
        List<SpinfoEntity> list = spinfoService.getLi(id);
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
    public SpinfoEntity getLast(){
        SpinfoEntity Spinfo = spinfoService.getLast();
        return  Spinfo;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    ////@RequiresPermissions("hdymzkjqrxt:spinfo:info")
    public R info(@PathVariable("id") Integer id){
		SpinfoEntity spinfo = spinfoService.getById(id);

        return R.ok().put("spinfo", spinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    ////@RequiresPermissions("hdymzkjqrxt:spinfo:save")
    public R save(@RequestBody SpinfoEntity spinfo){
		spinfoService.save(spinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    ////@RequiresPermissions("hdymzkjqrxt:spinfo:update")
    public R update(@RequestBody SpinfoEntity spinfo){
		spinfoService.updateById(spinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    ////@RequiresPermissions("hdymzkjqrxt:spinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		spinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
