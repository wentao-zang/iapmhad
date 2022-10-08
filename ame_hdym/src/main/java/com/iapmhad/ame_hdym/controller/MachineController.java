package com.iapmhad.ame_hdym.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.ame_hdym.entity.MachineEntity;
import com.iapmhad.ame_hdym.service.MachineService;
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
@RequestMapping("ame_hdym/machine")
public class MachineController {
    @Autowired
    private MachineService machineService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = machineService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{framename}")
    public R info(@PathVariable("framename") String framename){
		MachineEntity machine = machineService.getById(framename);

        return R.ok().put("machine", machine);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MachineEntity machine){
		machineService.save(machine);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MachineEntity machine){
		machineService.updateById(machine);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] framenames){
		machineService.removeByIds(Arrays.asList(framenames));

        return R.ok();
    }

}
