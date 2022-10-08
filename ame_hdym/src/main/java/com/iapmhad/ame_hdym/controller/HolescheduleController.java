package com.iapmhad.ame_hdym.controller;

import com.iapmhad.ame_hdym.entity.HolescheduleEntity;
import com.iapmhad.ame_hdym.service.HolescheduleService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-09-15 11:02:30
 */
@RestController
@RequestMapping("ame_hdym/holeschedule")
public class HolescheduleController {
    @Autowired
    private HolescheduleService holescheduleService;

    @RequestMapping("/getlast")
    public HolescheduleEntity getLast(@RequestParam Map<String, Object> params){
        HolescheduleEntity last = holescheduleService.getLast();
        return last;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = holescheduleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		HolescheduleEntity holeschedule = holescheduleService.getById(id);

        return R.ok().put("holeschedule", holeschedule);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HolescheduleEntity holeschedule){
		holescheduleService.save(holeschedule);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HolescheduleEntity holeschedule){
		holescheduleService.updateById(holeschedule);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		holescheduleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
