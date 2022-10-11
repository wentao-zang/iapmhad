package com.iapmhad.ame_hdym.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iapmhad.ame_hdym.entity.HoleMeasureEntity;
import com.iapmhad.ame_hdym.service.HoleMeasureService;
import com.iapmhad.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 
 *
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
@RefreshScope
@RestController
@RequestMapping("ame_hdym/holemeasure")
public class HoleMeasureController {
    @Autowired
    private HoleMeasureService holeMeasureService;

    @RequestMapping("/getli/{id}")
    public List<HoleMeasureEntity> getLi(@PathVariable("id") Integer id){
        List<HoleMeasureEntity> list = holeMeasureService.getLi(id);
        if(list.size()>100) {
            list = list.subList(list.size() - 100,list.size());
        }
        return list;
    }

    @RequestMapping("/chongji")
    ////@RequiresPermissions("hdymzkjqrxt:cpproduct:list")
    public Integer getChongJi(@RequestParam Map<String,String> params){
        List<HoleMeasureEntity> chongJi = holeMeasureService.getChongJi(params.get("strtime"));
        chongJi.forEach(System.out::println);
        Object[] holedia = chongJi.stream()
                .map(HoleMeasureEntity::getHoleDia).collect(Collectors.toList()).toArray();
        return null;
    }

    @RequestMapping("/getlast")
    ////@RequiresPermissions("hdymzkjqrxt:cpproduct:list")
    public HoleMeasureEntity getlast(@RequestParam Map<String,Object> params){
        HoleMeasureEntity last = holeMeasureService.getLast();
//        Double holeDia = last.getHoleDia();
        return last;
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    ////@RequiresPermissions("hdymzkjqrxt:cpproduct:list")
    public Object[] list(@RequestParam Map<String,Object> params){
//        for (Map.Entry<String,Object> entry : params.entrySet()) {
//            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//        }
        Object str = params.get("map");
        String str1 = (String)str;
        Object[] strrefine = holeMeasureService.strrefine(str1);
        List<HoleMeasureEntity> holeMeasureEntityList = new ArrayList<>();
        for(int i = 0;i < Integer.parseInt((String) params.get("length")); i++){
            QueryWrapper<HoleMeasureEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("aircraft_id",strrefine[4*i]).eq("flight_id",strrefine[4*i+1]+".000000")
            .eq("product_num",strrefine[4*i+2]+".000000")
             .between("hole_dia",Double.parseDouble((String) strrefine[4*i+3])*0.9,Double.parseDouble((String) strrefine[4*i+3])*1.1);
            List<HoleMeasureEntity> list1 = holeMeasureService.list(queryWrapper);
//            list1.forEach(System.out::println);
            holeMeasureEntityList.addAll(list1);
        }
        List<Double> holedia = holeMeasureEntityList.stream()
                .map(HoleMeasureEntity::getHoleDia).collect(Collectors.toList());
//        holedia.forEach(System.out::println);
        Object[] holearray = holedia.toArray();
        return holearray;
    }

    @RequestMapping("/statistics")
    ////@RequiresPermissions("hdymzkjqrxt:cpproduct:list")
    public Object[] statistics(@RequestParam Map<String,Object> params){
        for (Map.Entry<String,Object> entry : params.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        Object str = params.get("map");
        String str1 = (String)str;
        Object[] strrefine = holeMeasureService.strrefine(str1);
        QueryWrapper<HoleMeasureEntity> queryWrapper = new QueryWrapper<>();
        QueryWrapper<HoleMeasureEntity> queryWrapper1 = queryWrapper.between("hole_dia",Double.parseDouble((String) strrefine[0])*0.9,Double.parseDouble((String) strrefine[0])*1.1);;
        if(strrefine[1].equals("1")){
            queryWrapper1.lambda().apply("DATE_SUB(CURDATE(),INTERVAL 1 day) <= DATE(TIME)");
        }
        if(strrefine[1].equals("2")){
            queryWrapper1.lambda().apply("DATE_SUB(CURDATE(),INTERVAL 1 week) <= DATE(TIME)");
        }
        if(strrefine[1].equals("3")){
            queryWrapper1.lambda().apply("DATE_SUB(CURDATE(),INTERVAL 1 month) <= DATE(TIME)");
        }
        if(strrefine[1].equals("4")){
            queryWrapper1.lambda().apply("DATE_SUB(CURDATE(),INTERVAL 3 month) <= DATE(TIME)");
        }
        if(strrefine[1].equals("5")){
            queryWrapper.lambda().apply("DATE_SUB(CURDATE(),INTERVAL 6 month) <= DATE(TIME)");
        }
        if(strrefine[1].equals("6")){
            queryWrapper1.lambda().apply("DATE_SUB(CURDATE(),INTERVAL 1 year) <= DATE(TIME)");
        }
            List<HoleMeasureEntity> list1 = holeMeasureService.list(queryWrapper1);
//            list1.forEach(System.out::println);
        List<Double> holedia = list1.stream()
                .map(HoleMeasureEntity::getHoleDia).collect(Collectors.toList());
        holedia.forEach(System.out::println);
        Object[] holearray = holedia.toArray();
        return holearray;
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    ////@RequiresPermissions("hdymzkjqrxt:cpproduct:info")
    public R info(@PathVariable("id") Integer id){
		HoleMeasureEntity  holeMeasure= holeMeasureService.getById(id);
        System.out.println(holeMeasure);
        return R.ok().put("holemeasure", holeMeasure);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    ////@RequiresPermissions("hdymzkjqrxt:cpproduct:save")
    public R save(@RequestBody HoleMeasureEntity holeMeasure){
		holeMeasureService.save(holeMeasure);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    ////@RequiresPermissions("hdymzkjqrxt:cpproduct:update")
    public R update(@RequestBody HoleMeasureEntity holeMeasure){
        holeMeasureService.updateById(holeMeasure);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    ////@RequiresPermissions("hdymzkjqrxt:cpproduct:delete")
    public R delete(@RequestBody Integer[] ids){
        holeMeasureService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
