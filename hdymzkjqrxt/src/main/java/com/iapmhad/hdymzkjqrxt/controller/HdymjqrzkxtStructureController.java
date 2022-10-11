package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.HdymjqrzkxtStructureEntity;
import com.iapmhad.hdymzkjqrxt.service.HdymjqrzkxtStructureService;
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
@RequestMapping("hdymzkjqrxt/hdymjqrzkxtstructure")
public class HdymjqrzkxtStructureController {
    @Autowired
    private HdymjqrzkxtStructureService hdymjqrzkxtStructureService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    ////@RequiresPermissions("hdymzkjqrxt:hdymjqrzkxtstructure:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = hdymjqrzkxtStructureService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<HdymjqrzkxtStructureEntity> getLi(@PathVariable("id") Integer id) {
        List<HdymjqrzkxtStructureEntity> list = hdymjqrzkxtStructureService.getLi(id);
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
    public HdymjqrzkxtStructureEntity getLast(){
        HdymjqrzkxtStructureEntity HdymjqrzkxtStructure = hdymjqrzkxtStructureService.getLast();
        return  HdymjqrzkxtStructure;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    ////@RequiresPermissions("hdymzkjqrxt:hdymjqrzkxtstructure:info")
    public R info(@PathVariable("id") Integer id){
		HdymjqrzkxtStructureEntity hdymjqrzkxtStructure = hdymjqrzkxtStructureService.getById(id);

        return R.ok().put("hdymjqrzkxtStructure", hdymjqrzkxtStructure);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    ////@RequiresPermissions("hdymzkjqrxt:hdymjqrzkxtstructure:save")
    public R save(@RequestBody HdymjqrzkxtStructureEntity hdymjqrzkxtStructure){
		hdymjqrzkxtStructureService.save(hdymjqrzkxtStructure);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    ////@RequiresPermissions("hdymzkjqrxt:hdymjqrzkxtstructure:update")
    public R update(@RequestBody HdymjqrzkxtStructureEntity hdymjqrzkxtStructure){
		hdymjqrzkxtStructureService.updateById(hdymjqrzkxtStructure);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    ////@RequiresPermissions("hdymzkjqrxt:hdymjqrzkxtstructure:delete")
    public R delete(@RequestBody Integer[] ids){
		hdymjqrzkxtStructureService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
