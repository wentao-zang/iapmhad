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

import com.iapmhad.yh_postureadjust.entity.SpinfoEntity;
import com.iapmhad.yh_postureadjust.service.SpinfoService;
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
@RequestMapping("yh_postureadjust/spinfo")
public class SpinfoController {
    @Autowired
    private SpinfoService spinfoService;

    @RequestMapping("/getlast/{id}")
    public SpinfoEntity getlast(@PathVariable("id") Integer id){
        List<SpinfoEntity> last = spinfoService.getLi(id);
        if(last.size()!=0){
            SpinfoEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yh_postureadjust:spinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = spinfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yh_postureadjust:spinfo:info")
    public R info(@PathVariable("id") Integer id){
		SpinfoEntity spinfo = spinfoService.getById(id);

        return R.ok().put("spinfo", spinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yh_postureadjust:spinfo:save")
    public R save(@RequestBody SpinfoEntity spinfo){
		spinfoService.save(spinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yh_postureadjust:spinfo:update")
    public R update(@RequestBody SpinfoEntity spinfo){
		spinfoService.updateById(spinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yh_postureadjust:spinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		spinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
