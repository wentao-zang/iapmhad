package com.iapmhad.processParametersJqrzk.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.iapmhad.processParametersJqrzk.entity.GeneralHoleProcessEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.processParametersJqrzk.entity.FastenHoleProcessEntity;
import com.iapmhad.processParametersJqrzk.service.FastenHoleProcessService;
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
@RequestMapping("processParametersJqrzk/fastenholeprocess")
public class FastenHoleProcessController {
    @Autowired
    private FastenHoleProcessService fastenHoleProcessService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fastenHoleProcessService.queryPage(params);

        return R.ok().put("page", page);
    }
    @RequestMapping("/list/{pageNumber}")
    public R list(@RequestParam Map<String, Object> params, @PathVariable("pageNumber") Integer pageNumber) {
        PageUtils page = fastenHoleProcessService.queryPage(params);
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
    @RequestMapping("/info/{id}")
    public List<FastenHoleProcessEntity> info(@PathVariable("id") String id){
        FastenHoleProcessEntity fastenHoleProcess = fastenHoleProcessService.getById(id);
        List<FastenHoleProcessEntity> list = new ArrayList<>();
        list.add(fastenHoleProcess);
        System.out.println(fastenHoleProcess);
//        System.out.println(list);

        return list;
//        return R.ok().put("preliminaryConnectionHole", preliminaryConnectionHole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FastenHoleProcessEntity preliminaryConnectionHole){
        fastenHoleProcessService.save(preliminaryConnectionHole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FastenHoleProcessEntity fastenHoleProcess){
        FastenHoleProcessEntity fastenHoleProcess1 = fastenHoleProcessService.getById(fastenHoleProcess.getId());
        if (fastenHoleProcess1 == null) {
            return R.error("此工艺编号不存在");
        } else if (fastenHoleProcess1 != null) {
            fastenHoleProcessService.updateById(fastenHoleProcess);
            FastenHoleProcessEntity fastenHoleProcess2 = fastenHoleProcessService.getById(fastenHoleProcess.getId());
            return R.ok("修改成功").put("fastenHoleProcess1", fastenHoleProcess1).put("fastenHoleProcess2", fastenHoleProcess2);
        }
        return R.ok();
    }

    /**
     * 删除
     */


    @RequestMapping("/delete/{id}")
    public R delete(@PathVariable("id") String id) {
//        判断编号是否存在
        FastenHoleProcessEntity fastenHoleProcess = fastenHoleProcessService.getById(id);

        if(fastenHoleProcess!=null){
            List<String>ids=new ArrayList<>();
            ids.add(id);
            fastenHoleProcessService.removeByIds(ids);
            return R.ok("删除成功").put("fastenHoleProcess",fastenHoleProcess);
        }else if(fastenHoleProcess==null){
            return R.error("没有此工艺编号").put("fastenHoleProcess",fastenHoleProcess);
        }
        return R.ok();
    }

}
