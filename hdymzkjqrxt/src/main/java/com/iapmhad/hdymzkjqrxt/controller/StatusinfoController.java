package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.StatusinfoEntity;
import com.iapmhad.hdymzkjqrxt.service.StatusinfoService;
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
@RequestMapping("hdymzkjqrxt/statusinfo")
public class StatusinfoController {
    @Autowired
    private StatusinfoService statusinfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hdymzkjqrxt:statusinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = statusinfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<StatusinfoEntity> getLi(@PathVariable("id") Integer id) {
        List<StatusinfoEntity> list = statusinfoService.getLi(id);
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
    public StatusinfoEntity getLast(){
        StatusinfoEntity Statusinfo = statusinfoService.getLast();
        return  Statusinfo;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hdymzkjqrxt:statusinfo:info")
    public R info(@PathVariable("id") Integer id){
		StatusinfoEntity statusinfo = statusinfoService.getById(id);

        return R.ok().put("statusinfo", statusinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hdymzkjqrxt:statusinfo:save")
    public R save(@RequestBody StatusinfoEntity statusinfo){
		statusinfoService.save(statusinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hdymzkjqrxt:statusinfo:update")
    public R update(@RequestBody StatusinfoEntity statusinfo){
		statusinfoService.updateById(statusinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hdymzkjqrxt:statusinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		statusinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
