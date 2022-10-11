package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.FxclzzSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.FxclzzSpecificationService;
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
@RequestMapping("hdymzkjqrxt/fxclzzspecification")
public class FxclzzSpecificationController {
    @Autowired
    private FxclzzSpecificationService fxclzzSpecificationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    ////@RequiresPermissions("hdymzkjqrxt:fxclzzspecification:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fxclzzSpecificationService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<FxclzzSpecificationEntity> getLi(@PathVariable("id") Integer id) {
        List<FxclzzSpecificationEntity> list = fxclzzSpecificationService.getLi(id);
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
    public FxclzzSpecificationEntity getLast(){
        FxclzzSpecificationEntity FxclzzSpecification = fxclzzSpecificationService.getLast();
        return  FxclzzSpecification;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    ////@RequiresPermissions("hdymzkjqrxt:fxclzzspecification:info")
    public R info(@PathVariable("id") Integer id){
		FxclzzSpecificationEntity fxclzzSpecification = fxclzzSpecificationService.getById(id);

        return R.ok().put("fxclzzSpecification", fxclzzSpecification);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    ////@RequiresPermissions("hdymzkjqrxt:fxclzzspecification:save")
    public R save(@RequestBody FxclzzSpecificationEntity fxclzzSpecification){
		fxclzzSpecificationService.save(fxclzzSpecification);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    ////@RequiresPermissions("hdymzkjqrxt:fxclzzspecification:update")
    public R update(@RequestBody FxclzzSpecificationEntity fxclzzSpecification){
		fxclzzSpecificationService.updateById(fxclzzSpecification);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    ////@RequiresPermissions("hdymzkjqrxt:fxclzzspecification:delete")
    public R delete(@RequestBody Integer[] ids){
		fxclzzSpecificationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
