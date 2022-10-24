package com.iapmhad.jydbjdj.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.jydbjdj.entity.RwLocadisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.jydbjdj.entity.RwLocaloadEntity;
import com.iapmhad.jydbjdj.service.RwLocaloadService;
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
@RequestMapping("jydbjdj/rwlocaload")
public class RwLocaloadController {
    @Autowired
    private RwLocaloadService rwLocaloadService;

    @RequestMapping("/getlast/{id}")
    public RwLocaloadEntity getlast(@PathVariable("id") Integer id){
        List<RwLocaloadEntity> last = rwLocaloadService.getLi(id);
        if(last.size()!=0){
            RwLocaloadEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("jydbjdj:rwlocaload:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rwLocaloadService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("jydbjdj:rwlocaload:info")
    public R info(@PathVariable("id") Integer id){
		RwLocaloadEntity rwLocaload = rwLocaloadService.getById(id);

        return R.ok().put("rwLocaload", rwLocaload);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("jydbjdj:rwlocaload:save")
    public R save(@RequestBody RwLocaloadEntity rwLocaload){
		rwLocaloadService.save(rwLocaload);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("jydbjdj:rwlocaload:update")
    public R update(@RequestBody RwLocaloadEntity rwLocaload){
		rwLocaloadService.updateById(rwLocaload);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("jydbjdj:rwlocaload:delete")
    public R delete(@RequestBody Integer[] ids){
		rwLocaloadService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
