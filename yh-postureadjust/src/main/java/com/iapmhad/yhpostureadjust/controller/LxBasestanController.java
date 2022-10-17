package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LsLocaload2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LxBasestanEntity;
import com.iapmhad.yhpostureadjust.service.LxBasestanService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:11:17
 */
@RestController
@RequestMapping("yhpostureadjust/lxbasestan")
public class LxBasestanController {
    @Autowired
    private LxBasestanService lxBasestanService;

    @RequestMapping("/getlast/{id}")
    public LxBasestanEntity getlast(@PathVariable("id") Integer id){
        List<LxBasestanEntity> last = lxBasestanService.getLi(id);
        if(last.size()!=0){
            LxBasestanEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lxbasestan:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lxBasestanService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lxbasestan:info")
    public R info(@PathVariable("id") Integer id){
		LxBasestanEntity lxBasestan = lxBasestanService.getById(id);

        return R.ok().put("lxBasestan", lxBasestan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lxbasestan:save")
    public R save(@RequestBody LxBasestanEntity lxBasestan){
		lxBasestanService.save(lxBasestan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lxbasestan:update")
    public R update(@RequestBody LxBasestanEntity lxBasestan){
		lxBasestanService.updateById(lxBasestan);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lxbasestan:delete")
    public R delete(@RequestBody Integer[] ids){
		lxBasestanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
