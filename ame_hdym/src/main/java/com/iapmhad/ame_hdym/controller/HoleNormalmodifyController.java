package com.iapmhad.ame_hdym.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.ame_hdym.entity.HoleNormalmodifyEntity;
import com.iapmhad.ame_hdym.service.HoleNormalmodifyService;
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
@RequestMapping("ame_hdym/holenormalmodify")
public class HoleNormalmodifyController {
    @Autowired
    private HoleNormalmodifyService holeNormalmodifyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = holeNormalmodifyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{fixtureid}")
    public R info(@PathVariable("fixtureid") String fixtureid){
		HoleNormalmodifyEntity holeNormalmodify = holeNormalmodifyService.getById(fixtureid);

        return R.ok().put("holeNormalmodify", holeNormalmodify);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HoleNormalmodifyEntity holeNormalmodify){
		holeNormalmodifyService.save(holeNormalmodify);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HoleNormalmodifyEntity holeNormalmodify){
		holeNormalmodifyService.updateById(holeNormalmodify);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] fixtureids){
		holeNormalmodifyService.removeByIds(Arrays.asList(fixtureids));

        return R.ok();
    }

}
