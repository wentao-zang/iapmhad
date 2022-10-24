package com.iapmhad.jydbjdj.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.jydbjdj.entity.LwLocastanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.jydbjdj.entity.RwLocadisEntity;
import com.iapmhad.jydbjdj.service.RwLocadisService;
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
@RequestMapping("jydbjdj/rwlocadis")
public class RwLocadisController {
    @Autowired
    private RwLocadisService rwLocadisService;

    @RequestMapping("/getlast/{id}")
    public RwLocadisEntity getlast(@PathVariable("id") Integer id){
        List<RwLocadisEntity> last = rwLocadisService.getLi(id);
        if(last.size()!=0){
            RwLocadisEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("jydbjdj:rwlocadis:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rwLocadisService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("jydbjdj:rwlocadis:info")
    public R info(@PathVariable("id") Integer id){
		RwLocadisEntity rwLocadis = rwLocadisService.getById(id);

        return R.ok().put("rwLocadis", rwLocadis);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("jydbjdj:rwlocadis:save")
    public R save(@RequestBody RwLocadisEntity rwLocadis){
		rwLocadisService.save(rwLocadis);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("jydbjdj:rwlocadis:update")
    public R update(@RequestBody RwLocadisEntity rwLocadis){
		rwLocadisService.updateById(rwLocadis);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("jydbjdj:rwlocadis:delete")
    public R delete(@RequestBody Integer[] ids){
		rwLocadisService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
