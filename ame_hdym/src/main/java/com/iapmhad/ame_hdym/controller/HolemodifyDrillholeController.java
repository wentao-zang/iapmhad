package com.iapmhad.ame_hdym.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.ame_hdym.entity.HolemodifyDrillholeEntity;
import com.iapmhad.ame_hdym.service.HolemodifyDrillholeService;
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
@RequestMapping("ame_hdym/holemodifydrillhole")
public class HolemodifyDrillholeController {
    @Autowired
    private HolemodifyDrillholeService holemodifyDrillholeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = holemodifyDrillholeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		HolemodifyDrillholeEntity holemodifyDrillhole = holemodifyDrillholeService.getById(id);

        return R.ok().put("holemodifyDrillhole", holemodifyDrillhole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HolemodifyDrillholeEntity holemodifyDrillhole){
		holemodifyDrillholeService.save(holemodifyDrillhole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HolemodifyDrillholeEntity holemodifyDrillhole){
		holemodifyDrillholeService.updateById(holemodifyDrillhole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		holemodifyDrillholeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
