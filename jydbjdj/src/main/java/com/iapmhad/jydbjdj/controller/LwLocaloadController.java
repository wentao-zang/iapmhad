package com.iapmhad.jydbjdj.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.jydbjdj.entity.LwLocadisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.jydbjdj.entity.LwLocaloadEntity;
import com.iapmhad.jydbjdj.service.LwLocaloadService;
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
@RequestMapping("jydbjdj/lwlocaload")
public class LwLocaloadController {
    @Autowired
    private LwLocaloadService lwLocaloadService;

    @RequestMapping("/getlast/{id}")
    public LwLocaloadEntity getlast(@PathVariable("id") Integer id){
        List<LwLocaloadEntity> last = lwLocaloadService.getLi(id);
        if(last.size()!=0){
            LwLocaloadEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("jydbjdj:lwlocaload:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lwLocaloadService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("jydbjdj:lwlocaload:info")
    public R info(@PathVariable("id") Integer id){
		LwLocaloadEntity lwLocaload = lwLocaloadService.getById(id);

        return R.ok().put("lwLocaload", lwLocaload);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("jydbjdj:lwlocaload:save")
    public R save(@RequestBody LwLocaloadEntity lwLocaload){
		lwLocaloadService.save(lwLocaload);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("jydbjdj:lwlocaload:update")
    public R update(@RequestBody LwLocaloadEntity lwLocaload){
		lwLocaloadService.updateById(lwLocaload);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("jydbjdj:lwlocaload:delete")
    public R delete(@RequestBody Integer[] ids){
		lwLocaloadService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
