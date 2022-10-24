package com.iapmhad.jydbjdj.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.jydbjdj.entity.LwLocaloadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.jydbjdj.entity.LwLocastanEntity;
import com.iapmhad.jydbjdj.service.LwLocastanService;
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
@RequestMapping("jydbjdj/lwlocastan")
public class LwLocastanController {
    @Autowired
    private LwLocastanService lwLocastanService;

    @RequestMapping("/getlast/{id}")
    public LwLocastanEntity getlast(@PathVariable("id") Integer id){
        List<LwLocastanEntity> last = lwLocastanService.getLi(id);
        if(last.size()!=0){
            LwLocastanEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("jydbjdj:lwlocastan:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lwLocastanService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("jydbjdj:lwlocastan:info")
    public R info(@PathVariable("id") Integer id){
		LwLocastanEntity lwLocastan = lwLocastanService.getById(id);

        return R.ok().put("lwLocastan", lwLocastan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("jydbjdj:lwlocastan:save")
    public R save(@RequestBody LwLocastanEntity lwLocastan){
		lwLocastanService.save(lwLocastan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("jydbjdj:lwlocastan:update")
    public R update(@RequestBody LwLocastanEntity lwLocastan){
		lwLocastanService.updateById(lwLocastan);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("jydbjdj:lwlocastan:delete")
    public R delete(@RequestBody Integer[] ids){
		lwLocastanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
