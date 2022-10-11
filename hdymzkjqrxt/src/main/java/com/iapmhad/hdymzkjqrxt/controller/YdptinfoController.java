package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.YdptinfoEntity;
import com.iapmhad.hdymzkjqrxt.service.YdptinfoService;
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
@RequestMapping("hdymzkjqrxt/ydptinfo")
public class YdptinfoController {
    @Autowired
    private YdptinfoService ydptinfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    ////@RequiresPermissions("hdymzkjqrxt:ydptinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ydptinfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<YdptinfoEntity> getLi(@PathVariable("id") Integer id) {
        List<YdptinfoEntity> list = ydptinfoService.getLi(id);
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
    public YdptinfoEntity getLast(){
        YdptinfoEntity Ydptinfo = ydptinfoService.getLast();
        return  Ydptinfo;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    ////@RequiresPermissions("hdymzkjqrxt:ydptinfo:info")
    public R info(@PathVariable("id") Integer id){
		YdptinfoEntity ydptinfo = ydptinfoService.getById(id);

        return R.ok().put("ydptinfo", ydptinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    ////@RequiresPermissions("hdymzkjqrxt:ydptinfo:save")
    public R save(@RequestBody YdptinfoEntity ydptinfo){
		ydptinfoService.save(ydptinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    ////@RequiresPermissions("hdymzkjqrxt:ydptinfo:update")
    public R update(@RequestBody YdptinfoEntity ydptinfo){
		ydptinfoService.updateById(ydptinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    ////@RequiresPermissions("hdymzkjqrxt:ydptinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		ydptinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
