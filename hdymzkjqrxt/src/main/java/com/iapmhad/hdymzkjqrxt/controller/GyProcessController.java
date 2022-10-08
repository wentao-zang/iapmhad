package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.GyProcessEntity;
import com.iapmhad.hdymzkjqrxt.service.GyProcessService;
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
@RequestMapping("hdymzkjqrxt/gyprocess")
public class GyProcessController {
    @Autowired
    private GyProcessService gyProcessService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hdymzkjqrxt:gyprocess:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyProcessService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<GyProcessEntity> getLi(@PathVariable("id") Integer id) {
        List<GyProcessEntity> list = gyProcessService.getLi(id);
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
    public GyProcessEntity getLast(){
        GyProcessEntity GyProcess = gyProcessService.getLast();
        return  GyProcess;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hdymzkjqrxt:gyprocess:info")
    public R info(@PathVariable("id") Integer id){
		GyProcessEntity gyProcess = gyProcessService.getById(id);

        return R.ok().put("gyProcess", gyProcess);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hdymzkjqrxt:gyprocess:save")
    public R save(@RequestBody GyProcessEntity gyProcess){
		gyProcessService.save(gyProcess);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hdymzkjqrxt:gyprocess:update")
    public R update(@RequestBody GyProcessEntity gyProcess){
		gyProcessService.updateById(gyProcess);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hdymzkjqrxt:gyprocess:delete")
    public R delete(@RequestBody Integer[] ids){
		gyProcessService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
