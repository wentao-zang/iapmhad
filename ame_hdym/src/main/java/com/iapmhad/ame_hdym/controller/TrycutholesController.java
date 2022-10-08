package com.iapmhad.ame_hdym.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.ame_hdym.entity.TrycutholesEntity;
import com.iapmhad.ame_hdym.service.TrycutholesService;
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
@RequestMapping("ame_hdym/trycutholes")
public class TrycutholesController {
    @Autowired
    private TrycutholesService trycutholesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = trycutholesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{holeid}")
    public R info(@PathVariable("holeid") Integer holeid){
		TrycutholesEntity trycutholes = trycutholesService.getById(holeid);

        return R.ok().put("trycutholes", trycutholes);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TrycutholesEntity trycutholes){
		trycutholesService.save(trycutholes);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TrycutholesEntity trycutholes){
		trycutholesService.updateById(trycutholes);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] holeids){
		trycutholesService.removeByIds(Arrays.asList(holeids));

        return R.ok();
    }

}
