package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.HoleAccuracyEntity;
import com.iapmhad.hdymzkjqrxt.service.HoleAccuracyService;
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
@RequestMapping("hdymzkjqrxt/holeaccuracy")
public class HoleAccuracyController {
    @Autowired
    private HoleAccuracyService holeAccuracyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hdymzkjqrxt:holeaccuracy:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = holeAccuracyService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<HoleAccuracyEntity> getLi(@PathVariable("id") Integer id) {
        List<HoleAccuracyEntity> list = holeAccuracyService.getLi(id);
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
    public HoleAccuracyEntity getLast(){
        HoleAccuracyEntity HoleAccuracy = holeAccuracyService.getLast();
        return  HoleAccuracy;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hdymzkjqrxt:holeaccuracy:info")
    public R info(@PathVariable("id") Integer id){
		HoleAccuracyEntity holeAccuracy = holeAccuracyService.getById(id);

        return R.ok().put("holeAccuracy", holeAccuracy);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hdymzkjqrxt:holeaccuracy:save")
    public R save(@RequestBody HoleAccuracyEntity holeAccuracy){
		holeAccuracyService.save(holeAccuracy);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hdymzkjqrxt:holeaccuracy:update")
    public R update(@RequestBody HoleAccuracyEntity holeAccuracy){
		holeAccuracyService.updateById(holeAccuracy);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hdymzkjqrxt:holeaccuracy:delete")
    public R delete(@RequestBody Integer[] ids){
		holeAccuracyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
