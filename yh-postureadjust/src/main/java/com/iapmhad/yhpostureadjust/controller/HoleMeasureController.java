package com.iapmhad.yh_postureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LhfLocadisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yh_postureadjust.entity.HoleMeasureEntity;
import com.iapmhad.yh_postureadjust.service.HoleMeasureService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-12-13 21:37:47
 */
@RestController
@RequestMapping("yh_postureadjust/holemeasure")
public class HoleMeasureController {
    @Autowired
    private HoleMeasureService holeMeasureService;

    @RequestMapping("/getlast/{id}")
    public HoleMeasureEntity getlast(@PathVariable("id") Integer id){
        List<HoleMeasureEntity> last = holeMeasureService.getLi(id);
        if(last.size()!=0){
            HoleMeasureEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yh_postureadjust:holemeasure:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = holeMeasureService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yh_postureadjust:holemeasure:info")
    public R info(@PathVariable("id") Integer id){
		HoleMeasureEntity holeMeasure = holeMeasureService.getById(id);

        return R.ok().put("holeMeasure", holeMeasure);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yh_postureadjust:holemeasure:save")
    public R save(@RequestBody HoleMeasureEntity holeMeasure){
		holeMeasureService.save(holeMeasure);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yh_postureadjust:holemeasure:update")
    public R update(@RequestBody HoleMeasureEntity holeMeasure){
		holeMeasureService.updateById(holeMeasure);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yh_postureadjust:holemeasure:delete")
    public R delete(@RequestBody Integer[] ids){
		holeMeasureService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
