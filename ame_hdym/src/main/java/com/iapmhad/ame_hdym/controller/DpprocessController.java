package com.iapmhad.ame_hdym.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.ame_hdym.entity.DpprocessEntity;
import com.iapmhad.ame_hdym.service.DpprocessService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-09-15 11:02:31
 */
@RestController
@RequestMapping("ame_hdym/dpprocess")
public class DpprocessController {
    @Autowired
    private DpprocessService dpprocessService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dpprocessService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		DpprocessEntity dpprocess = dpprocessService.getById(id);

        return R.ok().put("dpprocess", dpprocess);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DpprocessEntity dpprocess){
		dpprocessService.save(dpprocess);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DpprocessEntity dpprocess){
		dpprocessService.updateById(dpprocess);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		dpprocessService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
