package com.iapmhad.processParametersJqrzk.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.processParametersJqrzk.entity.ColdExtrusionHoleProcessEntity;
import com.iapmhad.processParametersJqrzk.service.ColdExtrusionHoleProcessService;
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
@RefreshScope
@RequestMapping("processParametersJqrzk/coldextrusionholeprocess")
public class ColdExtrusionHoleProcessController {
    @Autowired
    private ColdExtrusionHoleProcessService coldExtrusionHoleProcessService;


    /**
     * 列表
     */
    @RequestMapping("/list/{pageNumber}")
    public R list(@RequestParam Map<String, Object> params, @PathVariable("pageNumber") Integer pageNumber) {
        PageUtils page = coldExtrusionHoleProcessService.queryPage(params);
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

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = coldExtrusionHoleProcessService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public List<ColdExtrusionHoleProcessEntity> info(@PathVariable("id") String id) {

        ColdExtrusionHoleProcessEntity coldExtrusionHoleProcess = coldExtrusionHoleProcessService.getById(id);

        List<ColdExtrusionHoleProcessEntity> list = new ArrayList<>();
        list.add(coldExtrusionHoleProcess);
        return list;
//		ColdExtrusionHoleProcessEntity coldExtrusionHole = coldExtrusionHoleProcessService.getById(id);
//        return R.ok().put("coldExtrusionHole", coldExtrusionHole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ColdExtrusionHoleProcessEntity coldExtrusionHole) {
        coldExtrusionHoleProcessService.save(coldExtrusionHole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ColdExtrusionHoleProcessEntity coldExtrusionHoleProcess) {
        System.out.println(1);
        ColdExtrusionHoleProcessEntity coldExtrusionHoleProcess1 = coldExtrusionHoleProcessService.getById(coldExtrusionHoleProcess.getId());
        if (coldExtrusionHoleProcess1 == null) {
            System.out.println(2);
            return R.error("此编号不存在");
        } else if (coldExtrusionHoleProcess1 != null) {
            System.out.println(3);
            coldExtrusionHoleProcessService.updateById(coldExtrusionHoleProcess);
            ColdExtrusionHoleProcessEntity coldExtrusionHoleProcess2 = coldExtrusionHoleProcessService.getById(coldExtrusionHoleProcess.getId());

            return R.ok("修改成功").put("coldExtrusionHoleProcess1", coldExtrusionHoleProcess1).put("coldExtrusionHoleProcess2", coldExtrusionHoleProcess2);
        }
        return R.ok();
//        coldExtrusionHoleProcessService.updateById(coldExtrusionHole);
//
//        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{id}")
    public R delete(@PathVariable("id") String id) {
        //        判断编号是否存在
        ColdExtrusionHoleProcessEntity coldExtrusionHoleProcesss = coldExtrusionHoleProcessService.getById(id);
        if (coldExtrusionHoleProcesss != null) {
            List<String>ids=new ArrayList<>();
            ids.add(id);
            coldExtrusionHoleProcessService.removeByIds(ids);
            return R.ok("删除成功").put("coldExtrusionHoleProcesss", coldExtrusionHoleProcesss);
        } else if (coldExtrusionHoleProcesss == null) {
            return R.error("没有此工艺编号").put("coldExtrusionHoleProcesss", coldExtrusionHoleProcesss);
        }
        return R.ok();
//        coldExtrusionHoleProcessService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
    }

}
