package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LhLocadis1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LhLocadis2Entity;
import com.iapmhad.yhpostureadjust.service.LhLocadis2Service;
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
@RequestMapping("yhpostureadjust/lhlocadis2")
public class LhLocadis2Controller {
    @Autowired
    private LhLocadis2Service lhLocadis2Service;

    @RequestMapping("/getlast/{id}")
    public LhLocadis2Entity getlast(@PathVariable("id") Integer id){
        List<LhLocadis2Entity> last = lhLocadis2Service.getLi(id);
        if(last.size()!=0){
            LhLocadis2Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lhlocadis2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lhLocadis2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lhlocadis2:info")
    public R info(@PathVariable("id") Integer id){
		LhLocadis2Entity lhLocadis2 = lhLocadis2Service.getById(id);

        return R.ok().put("lhLocadis2", lhLocadis2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lhlocadis2:save")
    public R save(@RequestBody LhLocadis2Entity lhLocadis2){
		lhLocadis2Service.save(lhLocadis2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lhlocadis2:update")
    public R update(@RequestBody LhLocadis2Entity lhLocadis2){
		lhLocadis2Service.updateById(lhLocadis2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lhlocadis2:delete")
    public R delete(@RequestBody Integer[] ids){
		lhLocadis2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
