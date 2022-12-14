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

import com.iapmhad.yh_postureadjust.entity.AxisinfoleEntity;
import com.iapmhad.yh_postureadjust.service.AxisinfoleService;
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
@RequestMapping("yh_postureadjust/axisinfole")
public class AxisinfoleController {
    @Autowired
    private AxisinfoleService axisinfoleService;

    @RequestMapping("/getlast/{id}")
    public AxisinfoleEntity getlast(@PathVariable("id") Integer id){
        List<AxisinfoleEntity> last = axisinfoleService.getLi(id);
        if(last.size()!=0){
            AxisinfoleEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yh_postureadjust:axisinfole:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = axisinfoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yh_postureadjust:axisinfole:info")
    public R info(@PathVariable("id") Integer id){
		AxisinfoleEntity axisinfole = axisinfoleService.getById(id);

        return R.ok().put("axisinfole", axisinfole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yh_postureadjust:axisinfole:save")
    public R save(@RequestBody AxisinfoleEntity axisinfole){
		axisinfoleService.save(axisinfole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yh_postureadjust:axisinfole:update")
    public R update(@RequestBody AxisinfoleEntity axisinfole){
		axisinfoleService.updateById(axisinfole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yh_postureadjust:axisinfole:delete")
    public R delete(@RequestBody Integer[] ids){
		axisinfoleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
