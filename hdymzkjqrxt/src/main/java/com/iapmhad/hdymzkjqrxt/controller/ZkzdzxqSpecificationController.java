package com.iapmhad.hdymzkjqrxt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.hdymzkjqrxt.entity.ZkzdzxqSpecificationEntity;
import com.iapmhad.hdymzkjqrxt.service.ZkzdzxqSpecificationService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;
import org.springframework.cloud.context.config.annotation.RefreshScope;




/**
 * 制孔终端执行器规格信息表
 *
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
@RefreshScope
@RestController
@RequestMapping("hdymzkjqrxt/zkzdzxqspecification")
public class ZkzdzxqSpecificationController {
    @Autowired
    private ZkzdzxqSpecificationService zkzdzxqSpecificationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hdymzkjqrxt:zkzdzxqspecification:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = zkzdzxqSpecificationService.queryPage(params);

        return R.ok().put("page", page);
    }

    /*
     *获取大于{id}的所有数据
     *
     * */
    @RequestMapping("/getLi/{id}")
    public List<ZkzdzxqSpecificationEntity> getLi(@PathVariable("id") Integer id) {
        List<ZkzdzxqSpecificationEntity> list = zkzdzxqSpecificationService.getLi(id);
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
    public ZkzdzxqSpecificationEntity getLast(){
        ZkzdzxqSpecificationEntity ZkzdzxqSpecification = zkzdzxqSpecificationService.getLast();
        return  ZkzdzxqSpecification;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hdymzkjqrxt:zkzdzxqspecification:info")
    public R info(@PathVariable("id") Integer id){
		ZkzdzxqSpecificationEntity zkzdzxqSpecification = zkzdzxqSpecificationService.getById(id);

        return R.ok().put("zkzdzxqSpecification", zkzdzxqSpecification);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hdymzkjqrxt:zkzdzxqspecification:save")
    public R save(@RequestBody ZkzdzxqSpecificationEntity zkzdzxqSpecification){
		zkzdzxqSpecificationService.save(zkzdzxqSpecification);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hdymzkjqrxt:zkzdzxqspecification:update")
    public R update(@RequestBody ZkzdzxqSpecificationEntity zkzdzxqSpecification){
		zkzdzxqSpecificationService.updateById(zkzdzxqSpecification);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hdymzkjqrxt:zkzdzxqspecification:delete")
    public R delete(@RequestBody Integer[] ids){
		zkzdzxqSpecificationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
