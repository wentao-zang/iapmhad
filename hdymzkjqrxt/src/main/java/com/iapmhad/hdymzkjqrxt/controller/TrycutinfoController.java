package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.TrycutinfoEntity;
import com.iapmhad.hdymzkjqrxt.service.TrycutinfoService;
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
@RequestMapping("hdymzkjqrxt/trycutinfo")
public class TrycutinfoController {
    @Autowired
    private TrycutinfoService trycutinfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hdymzkjqrxt:trycutinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = trycutinfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<TrycutinfoEntity> getLi(@PathVariable("id") Integer id) {
        List<TrycutinfoEntity> list = trycutinfoService.getLi(id);
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
    public TrycutinfoEntity getLast(){
        TrycutinfoEntity Trycutinfo = trycutinfoService.getLast();
        return  Trycutinfo;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hdymzkjqrxt:trycutinfo:info")
    public R info(@PathVariable("id") Integer id){
		TrycutinfoEntity trycutinfo = trycutinfoService.getById(id);

        return R.ok().put("trycutinfo", trycutinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hdymzkjqrxt:trycutinfo:save")
    public R save(@RequestBody TrycutinfoEntity trycutinfo){
		trycutinfoService.save(trycutinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hdymzkjqrxt:trycutinfo:update")
    public R update(@RequestBody TrycutinfoEntity trycutinfo){
		trycutinfoService.updateById(trycutinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hdymzkjqrxt:trycutinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		trycutinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
