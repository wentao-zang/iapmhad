package com.iapmhad.processParametersJqrzk.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.iapmhad.processParametersJqrzk.entity.ColdExtrusionHoleProcessEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.processParametersJqrzk.entity.ColdExtrusionHoleToolEntity;
import com.iapmhad.processParametersJqrzk.service.ColdExtrusionHoleToolService;
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
@RequestMapping("processParametersJqrzk/coldextrusionholetool")
public class ColdExtrusionHoleToolController {
    @Autowired
    private ColdExtrusionHoleToolService coldExtrusionHoleToolService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = coldExtrusionHoleToolService.queryPage(params);

        return R.ok().put("page", page);
    }
    @RequestMapping("/list/{pageNumber}")
    public R list(@RequestParam Map<String, Object> params,@PathVariable("pageNumber") Integer pageNumber){
        PageUtils page = coldExtrusionHoleToolService.queryPage(params);
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
    public List<ColdExtrusionHoleToolEntity> info(@PathVariable("cutterId") String cutterId){
        ColdExtrusionHoleToolEntity coldExtrusionHoleTool = coldExtrusionHoleToolService.getById(cutterId);
        List<ColdExtrusionHoleToolEntity> list= new ArrayList<>();
        list.add(coldExtrusionHoleTool);
//        System.out.println(fasteners);
//        System.out.println(list);
        return list;
//        return R.ok().put("coldExtrusionHoleCutter", coldExtrusionHoleCutter);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ColdExtrusionHoleToolEntity coldExtrusionHoleTool){
        coldExtrusionHoleToolService.save(coldExtrusionHoleTool);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ColdExtrusionHoleToolEntity coldExtrusionHoleTool){
        ColdExtrusionHoleToolEntity coldExtrusionHoleTool1 = coldExtrusionHoleToolService.getById(coldExtrusionHoleTool.getId());
        if(coldExtrusionHoleTool1==null){
            return R.error("此刀具编号不存在");
        }else if(coldExtrusionHoleTool1!=null){
            coldExtrusionHoleToolService.updateById(coldExtrusionHoleTool);
            ColdExtrusionHoleToolEntity coldExtrusionHoleTool2 = coldExtrusionHoleToolService.getById(coldExtrusionHoleTool.getId());

            return R.ok("修改成功").put("coldExtrusionHoleTool1",coldExtrusionHoleTool1).put("coldExtrusionHoleTool2",coldExtrusionHoleTool2);
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{id}")
    public R delete(@PathVariable("id") String id){
        ColdExtrusionHoleToolEntity coldExtrusionHoleTools = coldExtrusionHoleToolService.getById(id);
        if(coldExtrusionHoleTools!=null){
            List<String>ids=new ArrayList<>();
            ids.add(id);
            coldExtrusionHoleToolService.removeByIds(ids);
            return R.ok("删除成功").put("coldExtrusionHoleTools",coldExtrusionHoleTools);
        }else if(coldExtrusionHoleTools==null){
            return R.error("没有此刀具编号").put("coldExtrusionHoleTools",coldExtrusionHoleTools);
        }
        return R.ok();
    }
}
