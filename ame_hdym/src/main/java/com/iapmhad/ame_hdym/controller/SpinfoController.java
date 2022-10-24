package com.iapmhad.ame_hdym.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.iapmhad.ame_hdym.entity.AxisinfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.ame_hdym.entity.SpinfoEntity;
import com.iapmhad.ame_hdym.service.SpinfoService;
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
@RequestMapping("ame_hdym/spinfo")
public class SpinfoController {
    @Autowired
    private SpinfoService spinfoService;

    @RequestMapping("/getli/{id}")
    public List<SpinfoEntity> getLi(@PathVariable("id") Integer id){
        List<SpinfoEntity> list = spinfoService.getLi(id);
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
        PageUtils page = spinfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		SpinfoEntity spinfo = spinfoService.getById(id);

        return R.ok().put("spinfo", spinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SpinfoEntity spinfo){
		spinfoService.save(spinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SpinfoEntity spinfo){
		spinfoService.updateById(spinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		spinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
