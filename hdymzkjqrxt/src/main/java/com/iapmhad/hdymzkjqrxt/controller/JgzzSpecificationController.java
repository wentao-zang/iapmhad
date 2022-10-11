package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.JgzzSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.JgzzSpecificationService;
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
@RequestMapping("hdymzkjqrxt/jgzzspecification")
public class JgzzSpecificationController {
    @Autowired
    private JgzzSpecificationService jgzzSpecificationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    ////@RequiresPermissions("hdymzkjqrxt:jgzzspecification:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jgzzSpecificationService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<JgzzSpecificationEntity> getLi(@PathVariable("id") Integer id) {
        List<JgzzSpecificationEntity> list = jgzzSpecificationService.getLi(id);
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
    public JgzzSpecificationEntity getLast(){
        JgzzSpecificationEntity JgzzSpecification = jgzzSpecificationService.getLast();
        return  JgzzSpecification;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    ////@RequiresPermissions("hdymzkjqrxt:jgzzspecification:info")
    public R info(@PathVariable("id") Integer id){
		JgzzSpecificationEntity jgzzSpecification = jgzzSpecificationService.getById(id);

        return R.ok().put("jgzzSpecification", jgzzSpecification);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    ////@RequiresPermissions("hdymzkjqrxt:jgzzspecification:save")
    public R save(@RequestBody JgzzSpecificationEntity jgzzSpecification){
		jgzzSpecificationService.save(jgzzSpecification);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    ////@RequiresPermissions("hdymzkjqrxt:jgzzspecification:update")
    public R update(@RequestBody JgzzSpecificationEntity jgzzSpecification){
		jgzzSpecificationService.updateById(jgzzSpecification);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    ////@RequiresPermissions("hdymzkjqrxt:jgzzspecification:delete")
    public R delete(@RequestBody Integer[] ids){
		jgzzSpecificationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
