package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.iapmhad.hdymzkjqrxt.service.DkSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.CpProductEntity;
import com.iapmhad.hdymzkjqrxt.service.CpProductService;
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
@RequestMapping("hdymzkjqrxt/cpproduct")
public class CpProductController {
    @Autowired
    private CpProductService cpProductService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    ////@RequiresPermissions("hdymzkjqrxt:cpproduct:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cpProductService.queryPage(params);
        return R.ok().put("page", page);
    }


    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<CpProductEntity> getLi(@PathVariable("id") Integer id) {
        List<CpProductEntity> list = cpProductService.getLi(id);
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
    public CpProductEntity getLast(){
        CpProductEntity CpProduct = cpProductService.getLast();
        return  CpProduct;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    ////@RequiresPermissions("hdymzkjqrxt:cpproduct:info")
    public R info(@PathVariable("id") Integer id){
		CpProductEntity cpProduct = cpProductService.getById(id);

        return R.ok().put("cpProduct", cpProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    ////@RequiresPermissions("hdymzkjqrxt:cpproduct:save")
    public R save(@RequestBody CpProductEntity cpProduct){
		cpProductService.save(cpProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    ////@RequiresPermissions("hdymzkjqrxt:cpproduct:update")
    public R update(@RequestBody CpProductEntity cpProduct){
		cpProductService.updateById(cpProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    ////@RequiresPermissions("hdymzkjqrxt:cpproduct:delete")
    public R delete(@RequestBody Integer[] ids){
		cpProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
