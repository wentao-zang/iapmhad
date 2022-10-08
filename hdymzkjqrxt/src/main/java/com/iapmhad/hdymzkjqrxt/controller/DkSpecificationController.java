package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.DkSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.DkSpecificationService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;
import org.springframework.cloud.context.config.annotation.RefreshScope;




/**
 * 刀库规格信息表
 *
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
@RefreshScope
@RestController
@RequestMapping("hdymzkjqrxt/dkspecification")
public class DkSpecificationController {
    @Autowired
    private DkSpecificationService dkSpecificationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hdymzkjqrxt:dkspecification:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dkSpecificationService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<DkSpecificationEntity> getLi(@PathVariable("id") Integer id) {
        List<DkSpecificationEntity> list = dkSpecificationService.getLi(id);
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
    public DkSpecificationEntity getLast(){
        DkSpecificationEntity DkSpecification = dkSpecificationService.getLast();
        return  DkSpecification;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hdymzkjqrxt:dkspecification:info")
    public R info(@PathVariable("id") Integer id){
		DkSpecificationEntity dkSpecification = dkSpecificationService.getById(id);

        return R.ok().put("dkSpecification", dkSpecification);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hdymzkjqrxt:dkspecification:save")
    public R save(@RequestBody DkSpecificationEntity dkSpecification){
		dkSpecificationService.save(dkSpecification);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hdymzkjqrxt:dkspecification:update")
    public R update(@RequestBody DkSpecificationEntity dkSpecification){
		dkSpecificationService.updateById(dkSpecification);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hdymzkjqrxt:dkspecification:delete")
    public R delete(@RequestBody Integer[] ids){
		dkSpecificationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
