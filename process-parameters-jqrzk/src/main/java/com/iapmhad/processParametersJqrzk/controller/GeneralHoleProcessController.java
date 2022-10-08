package com.iapmhad.processParametersJqrzk.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.iapmhad.processParametersJqrzk.entity.ColdExtrusionHoleProcessEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.processParametersJqrzk.entity.GeneralHoleProcessEntity;
import com.iapmhad.processParametersJqrzk.service.GeneralHoleProcessService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;


/**
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-05-27 13:13:31
 */
@RestController
@RequestMapping("processParametersJqrzk/generalholeprocess")
public class GeneralHoleProcessController {
    @Autowired
    private GeneralHoleProcessService generalHoleProcessService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = generalHoleProcessService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/getLast")
    public Object getLast(@RequestParam Map<String, Object> params) {
        PageUtils page = generalHoleProcessService.queryPage(params);
        List<?> list0 = page.getList();
        int num = list0.size();
        if (num > 0) {
            return list0.get(num - 1);
        }
        return null;
    }

    @RequestMapping("/list/{pageNumber}")
    public R list(@RequestParam Map<String, Object> params, @PathVariable("pageNumber") Integer pageNumber) {
        PageUtils page = generalHoleProcessService.queryPage(params);
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
    public List<GeneralHoleProcessEntity> info(@PathVariable("id") String id) {
        GeneralHoleProcessEntity generalHoleProcess = generalHoleProcessService.getById(id);
        List<GeneralHoleProcessEntity> list = new ArrayList<>();
        list.add(generalHoleProcess);
//        System.out.println(fasteners);
//        System.out.println(list);
        return list;
//        return R.ok().put("generalHole", generalHole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GeneralHoleProcessEntity generalHoleProcess) {
        generalHoleProcessService.save(generalHoleProcess);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GeneralHoleProcessEntity generalHoleProcess) {
//		generalHoleProcessService.updateById(generalHole);
        GeneralHoleProcessEntity generalHoleProcess1 = generalHoleProcessService.getById(generalHoleProcess.getId());
        if (generalHoleProcess1 == null) {
            return R.error("此工艺编号不存在");
        } else if (generalHoleProcess1 != null) {
            generalHoleProcessService.updateById(generalHoleProcess);
            GeneralHoleProcessEntity generalHoleProcess2 = generalHoleProcessService.getById(generalHoleProcess.getId());

            return R.ok("修改成功").put("generalHoleProcess1", generalHoleProcess1).put("generalHoleProcess2", generalHoleProcess2);
        }
        return R.ok();
    }

    /**
     * 删除
     */


    @RequestMapping("/delete/{id}")
    public R delete(@PathVariable("id") String id) {
//        判断编号是否存在
        GeneralHoleProcessEntity generalHoleProcess = generalHoleProcessService.getById(id);
        if (generalHoleProcess != null) {
            List<String> ids = new ArrayList<>();
            ids.add(id);
            generalHoleProcessService.removeByIds(ids);
            return R.ok("删除成功").put("generalHoleProcess", generalHoleProcess);
        } else if (generalHoleProcess == null) {
            return R.error("没有此工艺编号").put("generalHoleProcess", generalHoleProcess);
        }
        return R.ok();
    }
}