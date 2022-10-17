package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LhfLocadisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LhfLocastanEntity;
import com.iapmhad.yhpostureadjust.service.LhfLocastanService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-17 18:27:30
 */
@RestController
@RequestMapping("yhpostureadjust/lhflocastan")
public class LhfLocastanController {
    @Autowired
    private LhfLocastanService lhfLocastanService;

    @RequestMapping("/getlast/{id}")
    public LhfLocastanEntity getlast(@PathVariable("id") Integer id){
        List<LhfLocastanEntity> last = lhfLocastanService.getLi(id);
        if(last.size()!=0){
            LhfLocastanEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lhflocastan:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lhfLocastanService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lhflocastan:info")
    public R info(@PathVariable("id") Integer id){
		LhfLocastanEntity lhfLocastan = lhfLocastanService.getById(id);

        return R.ok().put("lhfLocastan", lhfLocastan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lhflocastan:save")
    public R save(@RequestBody LhfLocastanEntity lhfLocastan){
		lhfLocastanService.save(lhfLocastan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lhflocastan:update")
    public R update(@RequestBody LhfLocastanEntity lhfLocastan){
		lhfLocastanService.updateById(lhfLocastan);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lhflocastan:delete")
    public R delete(@RequestBody Integer[] ids){
		lhfLocastanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
