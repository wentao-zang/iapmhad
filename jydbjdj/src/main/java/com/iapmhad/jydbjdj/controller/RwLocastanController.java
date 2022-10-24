package com.iapmhad.jydbjdj.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.jydbjdj.entity.RwLocaloadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.jydbjdj.entity.RwLocastanEntity;
import com.iapmhad.jydbjdj.service.RwLocastanService;
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
@RequestMapping("jydbjdj/rwlocastan")
public class RwLocastanController {
    @Autowired
    private RwLocastanService rwLocastanService;

    @RequestMapping("/getlast/{id}")
    public RwLocastanEntity getlast(@PathVariable("id") Integer id){
        List<RwLocastanEntity> last = rwLocastanService.getLi(id);
        if(last.size()!=0){
            RwLocastanEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("jydbjdj:rwlocastan:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rwLocastanService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("jydbjdj:rwlocastan:info")
    public R info(@PathVariable("id") Integer id){
		RwLocastanEntity rwLocastan = rwLocastanService.getById(id);

        return R.ok().put("rwLocastan", rwLocastan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("jydbjdj:rwlocastan:save")
    public R save(@RequestBody RwLocastanEntity rwLocastan){
		rwLocastanService.save(rwLocastan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("jydbjdj:rwlocastan:update")
    public R update(@RequestBody RwLocastanEntity rwLocastan){
		rwLocastanService.updateById(rwLocastan);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("jydbjdj:rwlocastan:delete")
    public R delete(@RequestBody Integer[] ids){
		rwLocastanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
