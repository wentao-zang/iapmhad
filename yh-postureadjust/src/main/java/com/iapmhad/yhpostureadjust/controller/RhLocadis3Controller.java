package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RhLocadis2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RhLocadis3Entity;
import com.iapmhad.yhpostureadjust.service.RhLocadis3Service;
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
@RequestMapping("yhpostureadjust/rhlocadis3")
public class RhLocadis3Controller {
    @Autowired
    private RhLocadis3Service rhLocadis3Service;

    @RequestMapping("/getlast/{id}")
    public RhLocadis3Entity getlast(@PathVariable("id") Integer id){
        List<RhLocadis3Entity> last = rhLocadis3Service.getLi(id);
        if(last.size()!=0){
            RhLocadis3Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rhlocadis3:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rhLocadis3Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rhlocadis3:info")
    public R info(@PathVariable("id") Integer id){
		RhLocadis3Entity rhLocadis3 = rhLocadis3Service.getById(id);

        return R.ok().put("rhLocadis3", rhLocadis3);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rhlocadis3:save")
    public R save(@RequestBody RhLocadis3Entity rhLocadis3){
		rhLocadis3Service.save(rhLocadis3);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rhlocadis3:update")
    public R update(@RequestBody RhLocadis3Entity rhLocadis3){
		rhLocadis3Service.updateById(rhLocadis3);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rhlocadis3:delete")
    public R delete(@RequestBody Integer[] ids){
		rhLocadis3Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
