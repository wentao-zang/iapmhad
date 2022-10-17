package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LqLocadisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RhfLocadisEntity;
import com.iapmhad.yhpostureadjust.service.RhfLocadisService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-17 18:27:31
 */
@RestController
@RequestMapping("yhpostureadjust/rhflocadis")
public class RhfLocadisController {
    @Autowired
    private RhfLocadisService rhfLocadisService;

    @RequestMapping("/getlast/{id}")
    public RhfLocadisEntity getlast(@PathVariable("id") Integer id){
        List<RhfLocadisEntity> last = rhfLocadisService.getLi(id);
        if(last.size()!=0){
            RhfLocadisEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rhflocadis:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rhfLocadisService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rhflocadis:info")
    public R info(@PathVariable("id") Integer id){
		RhfLocadisEntity rhfLocadis = rhfLocadisService.getById(id);

        return R.ok().put("rhfLocadis", rhfLocadis);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rhflocadis:save")
    public R save(@RequestBody RhfLocadisEntity rhfLocadis){
		rhfLocadisService.save(rhfLocadis);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rhflocadis:update")
    public R update(@RequestBody RhfLocadisEntity rhfLocadis){
		rhfLocadisService.updateById(rhfLocadis);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rhflocadis:delete")
    public R delete(@RequestBody Integer[] ids){
		rhfLocadisService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
