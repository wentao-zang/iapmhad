package com.iapmhad.processParametersJqrzk.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.processParametersJqrzk.entity.ModifyLogEntity;
import com.iapmhad.processParametersJqrzk.service.ModifyLogService;
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
@RequestMapping("processParametersJqrzk/modifylog")
public class ModifyLogController {
    @Autowired
    private ModifyLogService modifyLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = modifyLogService.queryPage(params);
        return R.ok().put("page", page);
    }
    @RequestMapping("/list/{pageNumber}")
    public R list(@RequestParam Map<String, Object> params, @PathVariable("pageNumber") Integer pageNumber){
        PageUtils page = modifyLogService.queryPage(params);
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
    public List<ModifyLogEntity> info(@PathVariable("id") Integer id){
        ModifyLogEntity modifyLog = modifyLogService.getById(id);
        List<ModifyLogEntity> list= new ArrayList<>();
        list.add(modifyLog);
        System.out.println(modifyLog);
        System.out.println(list);
        return list;
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ModifyLogEntity modifyLog){
        modifyLogService.save(modifyLog);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ModifyLogEntity modifyLog){
        modifyLogService.updateById(modifyLog);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        modifyLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
}