package com.iapmhad.yh_postureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yh_postureadjust.entity.AxisinforgEntity;
import com.iapmhad.yh_postureadjust.service.AxisinforgService;
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
@RequestMapping("yh_postureadjust/axisinforg")
public class AxisinforgController {
    @Autowired
    private AxisinforgService axisinforgService;

    @RequestMapping("/getlast/{id}")
    public AxisinforgEntity getlast(@PathVariable("id") Integer id){
        List<AxisinforgEntity> last = axisinforgService.getLi(id);
        if(last.size()!=0){
            AxisinforgEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yh_postureadjust:axisinforg:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = axisinforgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yh_postureadjust:axisinforg:info")
    public R info(@PathVariable("id") Integer id){
		AxisinforgEntity axisinforg = axisinforgService.getById(id);

        return R.ok().put("axisinforg", axisinforg);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yh_postureadjust:axisinforg:save")
    public R save(@RequestBody AxisinforgEntity axisinforg){
		axisinforgService.save(axisinforg);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yh_postureadjust:axisinforg:update")
    public R update(@RequestBody AxisinforgEntity axisinforg){
		axisinforgService.updateById(axisinforg);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yh_postureadjust:axisinforg:delete")
    public R delete(@RequestBody Integer[] ids){
		axisinforgService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
