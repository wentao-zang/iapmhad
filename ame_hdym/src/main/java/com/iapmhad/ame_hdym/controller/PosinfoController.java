package com.iapmhad.ame_hdym.controller;

import com.iapmhad.ame_hdym.entity.PosinfoEntity;
import com.iapmhad.ame_hdym.service.PosinfoService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;
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
 * @date 2022-09-15 11:02:30
 */
@RestController
@RequestMapping("ame_hdym/posinfo")
public class PosinfoController {
    @Autowired
    private PosinfoService posinfoService;


    @RequestMapping("/getli/{id}")
    public List<PosinfoEntity> getLi(@PathVariable("id") Integer id){
        List<PosinfoEntity> list = posinfoService.getLi(id);
        if(list.size()>100) {
            list = list.subList(list.size() - 100,list.size());
        }
        return list;
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = posinfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		PosinfoEntity posinfo = posinfoService.getById(id);

        return R.ok().put("posinfo", posinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PosinfoEntity posinfo){
		posinfoService.save(posinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PosinfoEntity posinfo){
		posinfoService.updateById(posinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		posinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
