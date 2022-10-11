package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.ProductinfoEntity;
import com.iapmhad.hdymzkjqrxt.service.ProductinfoService;
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
@RequestMapping("hdymzkjqrxt/productinfo")
public class ProductinfoController {
    @Autowired
    private ProductinfoService productinfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    ////@RequiresPermissions("hdymzkjqrxt:productinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productinfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<ProductinfoEntity> getLi(@PathVariable("id") Integer id) {
        List<ProductinfoEntity> list = productinfoService.getLi(id);
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
    public ProductinfoEntity getLast(){
        ProductinfoEntity Productinfo = productinfoService.getLast();
        return  Productinfo;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    ////@RequiresPermissions("hdymzkjqrxt:productinfo:info")
    public R info(@PathVariable("id") Integer id){
		ProductinfoEntity productinfo = productinfoService.getById(id);

        return R.ok().put("productinfo", productinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    ////@RequiresPermissions("hdymzkjqrxt:productinfo:save")
    public R save(@RequestBody ProductinfoEntity productinfo){
		productinfoService.save(productinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    ////@RequiresPermissions("hdymzkjqrxt:productinfo:update")
    public R update(@RequestBody ProductinfoEntity productinfo){
		productinfoService.updateById(productinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    ////@RequiresPermissions("hdymzkjqrxt:productinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		productinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
