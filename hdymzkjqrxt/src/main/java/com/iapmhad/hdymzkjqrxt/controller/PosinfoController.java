package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.PosinfoEntity;
import com.iapmhad.hdymzkjqrxt.service.PosinfoService;
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
@RequestMapping("hdymzkjqrxt/posinfo")
public class PosinfoController {
    @Autowired
    private PosinfoService posinfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    ////@RequiresPermissions("hdymzkjqrxt:posinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = posinfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<PosinfoEntity> getLi(@PathVariable("id") Integer id) {
        List<PosinfoEntity> list = posinfoService.getLi(id);
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
    public PosinfoEntity getLast(){
        PosinfoEntity Posinfo = posinfoService.getLast();
        return  Posinfo;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    ////@RequiresPermissions("hdymzkjqrxt:posinfo:info")
    public R info(@PathVariable("id") Integer id){
		PosinfoEntity posinfo = posinfoService.getById(id);

        return R.ok().put("posinfo", posinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    ////@RequiresPermissions("hdymzkjqrxt:posinfo:save")
    public R save(@RequestBody PosinfoEntity posinfo){
		posinfoService.save(posinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    ////@RequiresPermissions("hdymzkjqrxt:posinfo:update")
    public R update(@RequestBody PosinfoEntity posinfo){
		posinfoService.updateById(posinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    ////@RequiresPermissions("hdymzkjqrxt:posinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		posinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
