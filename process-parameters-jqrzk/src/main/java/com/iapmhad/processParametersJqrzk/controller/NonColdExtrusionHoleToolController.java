package com.iapmhad.processParametersJqrzk.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.iapmhad.processParametersJqrzk.entity.GeneralHoleProcessEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.processParametersJqrzk.entity.NonColdExtrusionHoleToolEntity;
import com.iapmhad.processParametersJqrzk.service.NonColdExtrusionHoleToolService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-05-27 13:13:31
 */
@RestController
@RequestMapping("processParametersJqrzk/noncoldextrusionholetool")
public class NonColdExtrusionHoleToolController {
    @Autowired
    private NonColdExtrusionHoleToolService nonColdExtrusionHoleToolService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = nonColdExtrusionHoleToolService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/getLast")
    public Object getLast(@RequestParam Map<String, Object> params) {
        PageUtils page = nonColdExtrusionHoleToolService.queryPage(params);
        List<?> list0 = page.getList();
        int num = list0.size();
        if (num > 0) {
            return list0.get(num - 1);
        }
        return null;
    }
    @RequestMapping("/list/{pageNumber}")
    public R list(@RequestParam Map<String, Object> params, @PathVariable("pageNumber") Integer pageNumber) {
        PageUtils page = nonColdExtrusionHoleToolService.queryPage(params);
        List<?> list0 = page.getList();
        int num = list0.size();
        if (pageNumber == 0) {
            return R.ok().put("pageNumber", num / 10 + 1).put("list", page.getList().subList(num / 10 * 10, num));
        } else if (pageNumber <= num / 10) {
            return R.ok().put("pageNumber", pageNumber).put("list", page.getList().subList(pageNumber * 10 - 10, pageNumber * 10));
        } else if (pageNumber > num / 10 + 1) {
            return null;
        } else {
            return R.ok().put("pageNumber", pageNumber).put("list", page.getList().subList(pageNumber * 10 - 10, num));
        }
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{cutterId}")
    public List<NonColdExtrusionHoleToolEntity> info(@PathVariable("cutterId") String cutterId) {
        NonColdExtrusionHoleToolEntity nonColdExtrusionHoleTool = nonColdExtrusionHoleToolService.getById(cutterId);
        List<NonColdExtrusionHoleToolEntity> list = new ArrayList<>();
        list.add(nonColdExtrusionHoleTool);
        System.out.println(nonColdExtrusionHoleTool);
//        System.out.println(list);

        return list;
//        return R.ok().put("nonColdExtrusionHoleCutter", nonColdExtrusionHoleCutter);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NonColdExtrusionHoleToolEntity nonColdExtrusionHoleCutter) {
        nonColdExtrusionHoleToolService.save(nonColdExtrusionHoleCutter);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody NonColdExtrusionHoleToolEntity nonColdExtrusionHoleTool) {
        NonColdExtrusionHoleToolEntity nonColdExtrusionHoleTool1 = nonColdExtrusionHoleToolService.getById(nonColdExtrusionHoleTool.getId());
        if (nonColdExtrusionHoleTool1 == null) {
            return R.error("此刀具编号不存在");
        } else if (nonColdExtrusionHoleTool1 != null) {
            nonColdExtrusionHoleToolService.updateById(nonColdExtrusionHoleTool);
            NonColdExtrusionHoleToolEntity nonColdExtrusionHoleTool2 = nonColdExtrusionHoleToolService.getById(nonColdExtrusionHoleTool.getId());
            return R.ok("修改成功").put("nonColdExtrusionHoleTool1", nonColdExtrusionHoleTool1).put("nonColdExtrusionHoleTool2", nonColdExtrusionHoleTool2);
        }
        return R.ok();
    }

    /**
     * 删除
     */

    @RequestMapping("/delete/{id}")
    public R delete(@PathVariable("id") String id) {
//        判断编号是否存在
        NonColdExtrusionHoleToolEntity nonColdExtrusionHoleTool = nonColdExtrusionHoleToolService.getById(id);
        if(nonColdExtrusionHoleTool!=null){
            List<String>ids=new ArrayList<>();
            ids.add(id);
            nonColdExtrusionHoleToolService.removeByIds(ids);
            return R.ok("删除成功").put("nonColdExtrusionHoleTool",nonColdExtrusionHoleTool);
        }else if(nonColdExtrusionHoleTool==null){
            return R.error("没有此刀具编号").put("nonColdExtrusionHoleTool",nonColdExtrusionHoleTool);
        }
        return R.ok();
    }

}
