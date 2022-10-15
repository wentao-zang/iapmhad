package com.iapmhad.yhmachinedrilling.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhmachinedrilling.entity.AxisinfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhmachinedrilling.entity.HoleMeasureEntity;
import com.iapmhad.yhmachinedrilling.service.HoleMeasureService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:15:34
 */
@RestController
@RequestMapping("yhmachinedrilling/holemeasure")
public class HoleMeasureController {
    @Autowired
    private HoleMeasureService holeMeasureService;

    @RequestMapping("/getli/{id}")
    public List<HoleMeasureEntity> getLi(@PathVariable("id") Integer id){
        List<HoleMeasureEntity> list = holeMeasureService.getLi(id);
        if(list.size()>300) {
            list = list.subList(list.size() - 300,list.size());
        }
//        list.forEach(System.out::println);
        return list;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhmachinedrilling:holemeasure:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = holeMeasureService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhmachinedrilling:holemeasure:info")
    public R info(@PathVariable("id") Integer id){
		HoleMeasureEntity holeMeasure = holeMeasureService.getById(id);

        return R.ok().put("holeMeasure", holeMeasure);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhmachinedrilling:holemeasure:save")
    public R save(@RequestBody HoleMeasureEntity holeMeasure){
		holeMeasureService.save(holeMeasure);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhmachinedrilling:holemeasure:update")
    public R update(@RequestBody HoleMeasureEntity holeMeasure){
		holeMeasureService.updateById(holeMeasure);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhmachinedrilling:holemeasure:delete")
    public R delete(@RequestBody Integer[] ids){
		holeMeasureService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
