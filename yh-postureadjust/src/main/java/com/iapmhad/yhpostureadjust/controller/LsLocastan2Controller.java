package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LsLocadis2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LsLocastan2Entity;
import com.iapmhad.yhpostureadjust.service.LsLocastan2Service;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:11:17
 */
@RestController
@RequestMapping("yhpostureadjust/lslocastan2")
public class LsLocastan2Controller {
    @Autowired
    private LsLocastan2Service lsLocastan2Service;

    @RequestMapping("/getlast/{id}")
    public LsLocastan2Entity getlast(@PathVariable("id") Integer id){
        List<LsLocastan2Entity> last = lsLocastan2Service.getLi(id);
        if(last.size()!=0){
            LsLocastan2Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lslocastan2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lsLocastan2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lslocastan2:info")
    public R info(@PathVariable("id") Integer id){
		LsLocastan2Entity lsLocastan2 = lsLocastan2Service.getById(id);

        return R.ok().put("lsLocastan2", lsLocastan2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lslocastan2:save")
    public R save(@RequestBody LsLocastan2Entity lsLocastan2){
		lsLocastan2Service.save(lsLocastan2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lslocastan2:update")
    public R update(@RequestBody LsLocastan2Entity lsLocastan2){
		lsLocastan2Service.updateById(lsLocastan2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lslocastan2:delete")
    public R delete(@RequestBody Integer[] ids){
		lsLocastan2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
