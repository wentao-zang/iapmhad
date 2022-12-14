package com.iapmhad.yh_postureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yh_postureadjust.entity.ProductinfoEntity;
import com.iapmhad.yh_postureadjust.service.ProductinfoService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-12-13 21:37:47
 */
@RestController
@RequestMapping("yh_postureadjust/productinfo")
public class ProductinfoController {
    @Autowired
    private ProductinfoService productinfoService;

    @RequestMapping("/getlast/{id}")
    public ProductinfoEntity getlast(@PathVariable("id") Integer id){
        List<ProductinfoEntity> last = productinfoService.getLi(id);
        if(last.size()!=0){
            ProductinfoEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yh_postureadjust:productinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productinfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yh_postureadjust:productinfo:info")
    public R info(@PathVariable("id") Integer id){
		ProductinfoEntity productinfo = productinfoService.getById(id);

        return R.ok().put("productinfo", productinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yh_postureadjust:productinfo:save")
    public R save(@RequestBody ProductinfoEntity productinfo){
		productinfoService.save(productinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yh_postureadjust:productinfo:update")
    public R update(@RequestBody ProductinfoEntity productinfo){
		productinfoService.updateById(productinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yh_postureadjust:productinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		productinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
