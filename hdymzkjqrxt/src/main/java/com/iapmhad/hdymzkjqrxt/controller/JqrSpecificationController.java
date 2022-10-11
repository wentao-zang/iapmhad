package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.JqrSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.JqrSpecificationService;
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
@RequestMapping("hdymzkjqrxt/jqrspecification")
public class JqrSpecificationController {
    @Autowired
    private JqrSpecificationService jqrSpecificationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    ////@RequiresPermissions("hdymzkjqrxt:jqrspecification:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jqrSpecificationService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<JqrSpecificationEntity> getLi(@PathVariable("id") Integer id) {
        List<JqrSpecificationEntity> list = jqrSpecificationService.getLi(id);
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
    public JqrSpecificationEntity getLast(){
        JqrSpecificationEntity JqrSpecification = jqrSpecificationService.getLast();
        return  JqrSpecification;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    ////@RequiresPermissions("hdymzkjqrxt:jqrspecification:info")
    public R info(@PathVariable("id") Integer id){
		JqrSpecificationEntity jqrSpecification = jqrSpecificationService.getById(id);

        return R.ok().put("jqrSpecification", jqrSpecification);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    ////@RequiresPermissions("hdymzkjqrxt:jqrspecification:save")
    public R save(@RequestBody JqrSpecificationEntity jqrSpecification){
		jqrSpecificationService.save(jqrSpecification);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    ////@RequiresPermissions("hdymzkjqrxt:jqrspecification:update")
    public R update(@RequestBody JqrSpecificationEntity jqrSpecification){
		jqrSpecificationService.updateById(jqrSpecification);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    ////@RequiresPermissions("hdymzkjqrxt:jqrspecification:delete")
    public R delete(@RequestBody Integer[] ids){
		jqrSpecificationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
