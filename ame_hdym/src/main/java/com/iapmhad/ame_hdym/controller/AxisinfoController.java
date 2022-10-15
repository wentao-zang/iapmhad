package com.iapmhad.ame_hdym.controller;

import com.iapmhad.ame_hdym.entity.HoleMeasureEntity;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;
import com.iapmhad.ame_hdym.entity.AxisinfoEntity;
import com.iapmhad.ame_hdym.service.AxisinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-09-15 11:02:31
 */
@RestController
@RequestMapping("ame_hdym/axisinfo")
public class AxisinfoController {
    @Autowired
    private AxisinfoService axisinfoService;

    @RequestMapping("/getli/{id}")
    public List<AxisinfoEntity> getLi(@PathVariable("id") Integer id){
        List<AxisinfoEntity> list = axisinfoService.getLi(id);
        if(list.size()>100) {
            list = list.subList(list.size() - 100,list.size());
        }
//        list.forEach(System.out::println);
        return list;
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = axisinfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		AxisinfoEntity axisinfo = axisinfoService.getById(id);

        return R.ok().put("axisinfo", axisinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AxisinfoEntity axisinfo){
		axisinfoService.save(axisinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AxisinfoEntity axisinfo){
		axisinfoService.updateById(axisinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		axisinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
