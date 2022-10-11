package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.YdptSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.YdptSpecificationService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;
import org.springframework.cloud.context.config.annotation.RefreshScope;




/**
 * 移动平台规格信息表
 *
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
@RefreshScope
@RestController
@RequestMapping("hdymzkjqrxt/ydptspecification")
public class YdptSpecificationController {
    @Autowired
    private YdptSpecificationService ydptSpecificationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    ////@RequiresPermissions("hdymzkjqrxt:ydptspecification:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ydptSpecificationService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<YdptSpecificationEntity> getLi(@PathVariable("id") Integer id) {
        List<YdptSpecificationEntity> list = ydptSpecificationService.getLi(id);
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
    public YdptSpecificationEntity getLast(){
        YdptSpecificationEntity YdptSpecification = ydptSpecificationService.getLast();
        return  YdptSpecification;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    ////@RequiresPermissions("hdymzkjqrxt:ydptspecification:info")
    public R info(@PathVariable("id") Integer id){
		YdptSpecificationEntity ydptSpecification = ydptSpecificationService.getById(id);

        return R.ok().put("ydptSpecification", ydptSpecification);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    ////@RequiresPermissions("hdymzkjqrxt:ydptspecification:save")
    public R save(@RequestBody YdptSpecificationEntity ydptSpecification){
		ydptSpecificationService.save(ydptSpecification);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    ////@RequiresPermissions("hdymzkjqrxt:ydptspecification:update")
    public R update(@RequestBody YdptSpecificationEntity ydptSpecification){
		ydptSpecificationService.updateById(ydptSpecification);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    ////@RequiresPermissions("hdymzkjqrxt:ydptspecification:delete")
    public R delete(@RequestBody Integer[] ids){
		ydptSpecificationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
