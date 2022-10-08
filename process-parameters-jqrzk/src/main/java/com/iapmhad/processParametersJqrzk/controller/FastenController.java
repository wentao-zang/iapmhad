package com.iapmhad.processParametersJqrzk.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.processParametersJqrzk.entity.FastenEntity;
import com.iapmhad.processParametersJqrzk.service.FastenService;
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
@RequestMapping("processParametersJqrzk/fasten")
public class FastenController {
    @Autowired
    private FastenService fastenService;

    /**
     * 列表
     */
    @RequestMapping("/list/{pageNumber}")
    public R list(@RequestParam Map<String, Object> params,@PathVariable("pageNumber") Integer pageNumber){
        PageUtils page = fastenService.queryPage(params);
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
        PageUtils page = fastenService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{prefastenerId}")
    public List<FastenEntity>  info(@PathVariable("prefastenerId") String prefastenerId){
        FastenEntity fastens = fastenService.getById(prefastenerId);
        List<FastenEntity> list= new ArrayList<>();
        list.add(fastens);
        System.out.println(fastens);
//        System.out.println(list);

        return list;
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FastenEntity fasten){
        System.out.println("新增："+fasten);
        fastenService.save(fasten);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FastenEntity fasten){
//        List<FastenEntity> list=info(fasteners.getPrefastenerId());
        FastenEntity fasten1 = fastenService.getById(fasten.getId());
        if(fasten1==null){
            return R.error("此预紧固件编号不存在");
        }else if(fasten1!=null){
            fastenService.updateById(fasten);
            FastenEntity fasten2 = fastenService.getById(fasten.getId());
            System.out.println("更新前："+fasten1);
            System.out.println("更新后："+fasten2);
            return R.ok("修改成功").put("fasten1",fasten1).put("fasten2",fasten2);
        }

        return R.error();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{id}")
    public R delete(@PathVariable("id") String id){
//        判断编号是否存在
        String [] Ids={id};
        FastenEntity fasten = fastenService.getById(Ids[0]);
        System.out.println("删除："+fasten);
        if(fasten!=null){
            fastenService.removeByIds(Arrays.asList(Ids));
            return R.ok("删除成功").put("fasteners",fasten);
        }else if(fasten==null){
            return R.error("没有此预紧固件编号").put("fasteners",fasten);
        }
        return R.ok();
    }
}