package com.iapmhad.jydbjdj.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LsLocadis1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LhfLocadisEntity;
import com.iapmhad.yhpostureadjust.service.LhfLocadisService;
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
@RequestMapping("jydbjdj/lhflocadis")
public class LhfLocadisController {
    @Autowired
    private LhfLocadisService lhfLocadisService;

    @RequestMapping("/getlast/{id}")
    public LhfLocadisEntity getlast(@PathVariable("id") Integer id){
        List<LhfLocadisEntity> last = lhfLocadisService.getLi(id);
        if(last.size()!=0){
            LhfLocadisEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("jydbjdj:lhflocadis:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lhfLocadisService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("jydbjdj:lhflocadis:info")
    public R info(@PathVariable("id") Integer id){
		LhfLocadisEntity lhfLocadis = lhfLocadisService.getById(id);

        return R.ok().put("lhfLocadis", lhfLocadis);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("jydbjdj:lhflocadis:save")
    public R save(@RequestBody LhfLocadisEntity lhfLocadis){
		lhfLocadisService.save(lhfLocadis);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("jydbjdj:lhflocadis:update")
    public R update(@RequestBody LhfLocadisEntity lhfLocadis){
		lhfLocadisService.updateById(lhfLocadis);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("jydbjdj:lhflocadis:delete")
    public R delete(@RequestBody Integer[] ids){
		lhfLocadisService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
