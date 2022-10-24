package com.iapmhad.jydbjdj.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.jydbjdj.entity.JyLocastanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.jydbjdj.entity.LwLocadisEntity;
import com.iapmhad.jydbjdj.service.LwLocadisService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-20 15:50:00
 */
@RestController
@RequestMapping("jydbjdj/lwlocadis")
public class LwLocadisController {
    @Autowired
    private LwLocadisService lwLocadisService;

    @RequestMapping("/getlast/{id}")
    public LwLocadisEntity getlast(@PathVariable("id") Integer id){
        List<LwLocadisEntity> last = lwLocadisService.getLi(id);
        if(last.size()!=0){
            LwLocadisEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("jydbjdj:lwlocadis:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lwLocadisService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("jydbjdj:lwlocadis:info")
    public R info(@PathVariable("id") Integer id){
		LwLocadisEntity lwLocadis = lwLocadisService.getById(id);

        return R.ok().put("lwLocadis", lwLocadis);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("jydbjdj:lwlocadis:save")
    public R save(@RequestBody LwLocadisEntity lwLocadis){
		lwLocadisService.save(lwLocadis);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("jydbjdj:lwlocadis:update")
    public R update(@RequestBody LwLocadisEntity lwLocadis){
		lwLocadisService.updateById(lwLocadis);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("jydbjdj:lwlocadis:delete")
    public R delete(@RequestBody Integer[] ids){
		lwLocadisService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
