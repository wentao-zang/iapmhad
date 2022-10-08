package com.iapmhad.processParametersJqrzk.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.iapmhad.processParametersJqrzk.entity.GeneralHoleProcessEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.processParametersJqrzk.entity.PointTracingProcessEntity;
import com.iapmhad.processParametersJqrzk.service.PointTracingProcessService;
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
@RequestMapping("processParametersJqrzk/pointtracingprocess")
public class PointTracingProcessController {
    @Autowired
    private PointTracingProcessService pointTracingProcessService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pointTracingProcessService.queryPage(params);

        return R.ok().put("page", page);
    }
    @RequestMapping("/list/{pageNumber}")
    public R list(@RequestParam Map<String, Object> params, @PathVariable("pageNumber") Integer pageNumber) {
        PageUtils page = pointTracingProcessService.queryPage(params);
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
    public List<PointTracingProcessEntity> info(@PathVariable("id") String id){
        PointTracingProcessEntity pointTracingProcess = pointTracingProcessService.getById(id);
        List<PointTracingProcessEntity> list = new ArrayList<>();
        list.add(pointTracingProcess);
        System.out.println(pointTracingProcess);
//        System.out.println(list);
        return list;
//        return R.ok().put("tracingPoint", tracingPoint);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PointTracingProcessEntity pointTracingProcess){
        pointTracingProcessService.save(pointTracingProcess);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PointTracingProcessEntity pointTracingProcess){
        PointTracingProcessEntity pointTracingProces1 = pointTracingProcessService.getById(pointTracingProcess.getId());
        if (pointTracingProces1 == null) {
            return R.error("此工艺编号不存在");
        } else if (pointTracingProces1 != null) {
            pointTracingProcessService.updateById(pointTracingProcess);
            PointTracingProcessEntity pointTracingProces2 = pointTracingProcessService.getById(pointTracingProcess.getId());
            return R.ok("修改成功").put("pointTracingProces1", pointTracingProces1).put("pointTracingProces2", pointTracingProces2);
        }
        return R.ok();
    }

    /**
     * 删除
     */

    @RequestMapping("/delete/{id}")
    public R delete(@PathVariable("id") String id) {
//        判断编号是否存在
        PointTracingProcessEntity pointTracingProcess = pointTracingProcessService.getById(id);
        if(pointTracingProcess!=null){
            List<String>ids=new ArrayList<>();
            ids.add(id);
            pointTracingProcessService.removeByIds(ids);
            return R.ok("删除成功").put("pointTracingProcess",pointTracingProcess);
        }else if(pointTracingProcess==null){
            return R.error("没有此工艺编号").put("pointTracingProcess",pointTracingProcess);
        }
        return R.ok();
    }

}
