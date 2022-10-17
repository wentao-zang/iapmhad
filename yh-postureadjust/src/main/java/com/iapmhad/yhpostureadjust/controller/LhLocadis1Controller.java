package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LhfLocastanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LhLocadis1Entity;
import com.iapmhad.yhpostureadjust.service.LhLocadis1Service;
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
@RequestMapping("yhpostureadjust/lhlocadis1")
public class LhLocadis1Controller {
    @Autowired
    private LhLocadis1Service lhLocadis1Service;

    @RequestMapping("/getlast/{id}")
    public LhLocadis1Entity getlast(@PathVariable("id") Integer id){
        List<LhLocadis1Entity> last = lhLocadis1Service.getLi(id);
        if(last.size()!=0){
            LhLocadis1Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lhlocadis1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lhLocadis1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lhlocadis1:info")
    public R info(@PathVariable("id") Integer id){
		LhLocadis1Entity lhLocadis1 = lhLocadis1Service.getById(id);

        return R.ok().put("lhLocadis1", lhLocadis1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lhlocadis1:save")
    public R save(@RequestBody LhLocadis1Entity lhLocadis1){
		lhLocadis1Service.save(lhLocadis1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lhlocadis1:update")
    public R update(@RequestBody LhLocadis1Entity lhLocadis1){
		lhLocadis1Service.updateById(lhLocadis1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lhlocadis1:delete")
    public R delete(@RequestBody Integer[] ids){
		lhLocadis1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
