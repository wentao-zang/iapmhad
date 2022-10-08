package com.iapmhad.ame_hdym.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.ame_hdym.entity.ProductinfoEntity;
import com.iapmhad.ame_hdym.service.ProductinfoService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-09-15 11:02:30
 */
@RestController
@RequestMapping("ame_hdym/productinfo")
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
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productinfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		ProductinfoEntity productinfo = productinfoService.getById(id);

        return R.ok().put("productinfo", productinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ProductinfoEntity productinfo){
		productinfoService.save(productinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ProductinfoEntity productinfo){
		productinfoService.updateById(productinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		productinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
