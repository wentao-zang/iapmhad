package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.SjclzzSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.SjclzzSpecificationService;
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
@RequestMapping("hdymzkjqrxt/sjclzzspecification")
public class SjclzzSpecificationController {
    @Autowired
    private SjclzzSpecificationService sjclzzSpecificationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    ////@RequiresPermissions("hdymzkjqrxt:sjclzzspecification:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sjclzzSpecificationService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<SjclzzSpecificationEntity> getLi(@PathVariable("id") Integer id) {
        List<SjclzzSpecificationEntity> list = sjclzzSpecificationService.getLi(id);
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
    public SjclzzSpecificationEntity getLast(){
        SjclzzSpecificationEntity SjclzzSpecification = sjclzzSpecificationService.getLast();
        return  SjclzzSpecification;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    ////@RequiresPermissions("hdymzkjqrxt:sjclzzspecification:info")
    public R info(@PathVariable("id") Integer id){
		SjclzzSpecificationEntity sjclzzSpecification = sjclzzSpecificationService.getById(id);

        return R.ok().put("sjclzzSpecification", sjclzzSpecification);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    ////@RequiresPermissions("hdymzkjqrxt:sjclzzspecification:save")
    public R save(@RequestBody SjclzzSpecificationEntity sjclzzSpecification){
		sjclzzSpecificationService.save(sjclzzSpecification);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    ////@RequiresPermissions("hdymzkjqrxt:sjclzzspecification:update")
    public R update(@RequestBody SjclzzSpecificationEntity sjclzzSpecification){
		sjclzzSpecificationService.updateById(sjclzzSpecification);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    ////@RequiresPermissions("hdymzkjqrxt:sjclzzspecification:delete")
    public R delete(@RequestBody Integer[] ids){
		sjclzzSpecificationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
