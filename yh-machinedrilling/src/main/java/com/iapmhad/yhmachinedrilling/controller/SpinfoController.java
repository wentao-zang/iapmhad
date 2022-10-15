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

import com.iapmhad.yhmachinedrilling.entity.SpinfoEntity;
import com.iapmhad.yhmachinedrilling.service.SpinfoService;
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
@RequestMapping("yhmachinedrilling/spinfo")
public class SpinfoController {
    @Autowired
    private SpinfoService spinfoService;

    /**
     * 列表
     */
    @RequestMapping("/getli/{id}")
    public List<SpinfoEntity> getLi(@PathVariable("id") Integer id){
        List<SpinfoEntity> list = spinfoService.getLi(id);
        if(list.size()>300) {
            list = list.subList(list.size() - 300,list.size());
        }
//        list.forEach(System.out::println);
        return list;
    }

    @RequestMapping("/list")
    //@RequiresPermissions("yhmachinedrilling:spinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = spinfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhmachinedrilling:spinfo:info")
    public R info(@PathVariable("id") Integer id){
		SpinfoEntity spinfo = spinfoService.getById(id);

        return R.ok().put("spinfo", spinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhmachinedrilling:spinfo:save")
    public R save(@RequestBody SpinfoEntity spinfo){
		spinfoService.save(spinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhmachinedrilling:spinfo:update")
    public R update(@RequestBody SpinfoEntity spinfo){
		spinfoService.updateById(spinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhmachinedrilling:spinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		spinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
