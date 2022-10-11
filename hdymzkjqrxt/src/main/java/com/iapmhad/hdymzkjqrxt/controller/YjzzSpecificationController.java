package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.YjzzSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.YjzzSpecificationService;
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
@RequestMapping("hdymzkjqrxt/yjzzspecification")
public class YjzzSpecificationController {
    @Autowired
    private YjzzSpecificationService yjzzSpecificationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    ////@RequiresPermissions("hdymzkjqrxt:yjzzspecification:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = yjzzSpecificationService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<YjzzSpecificationEntity> getLi(@PathVariable("id") Integer id) {
        List<YjzzSpecificationEntity> list = yjzzSpecificationService.getLi(id);
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
    public YjzzSpecificationEntity getLast(){
        YjzzSpecificationEntity YjzzSpecification = yjzzSpecificationService.getLast();
        return  YjzzSpecification;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    ////@RequiresPermissions("hdymzkjqrxt:yjzzspecification:info")
    public R info(@PathVariable("id") Integer id){
		YjzzSpecificationEntity yjzzSpecification = yjzzSpecificationService.getById(id);

        return R.ok().put("yjzzSpecification", yjzzSpecification);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    ////@RequiresPermissions("hdymzkjqrxt:yjzzspecification:save")
    public R save(@RequestBody YjzzSpecificationEntity yjzzSpecification){
		yjzzSpecificationService.save(yjzzSpecification);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    ////@RequiresPermissions("hdymzkjqrxt:yjzzspecification:update")
    public R update(@RequestBody YjzzSpecificationEntity yjzzSpecification){
		yjzzSpecificationService.updateById(yjzzSpecification);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    ////@RequiresPermissions("hdymzkjqrxt:yjzzspecification:delete")
    public R delete(@RequestBody Integer[] ids){
		yjzzSpecificationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
