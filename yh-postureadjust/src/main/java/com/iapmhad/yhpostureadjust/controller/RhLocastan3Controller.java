package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RhLocastan2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RhLocastan3Entity;
import com.iapmhad.yhpostureadjust.service.RhLocastan3Service;
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
@RequestMapping("yhpostureadjust/rhlocastan3")
public class RhLocastan3Controller {
    @Autowired
    private RhLocastan3Service rhLocastan3Service;

    @RequestMapping("/getlast/{id}")
    public RhLocastan3Entity getlast(@PathVariable("id") Integer id){
        List<RhLocastan3Entity> last = rhLocastan3Service.getLi(id);
        if(last.size()!=0){
            RhLocastan3Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rhlocastan3:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rhLocastan3Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rhlocastan3:info")
    public R info(@PathVariable("id") Integer id){
		RhLocastan3Entity rhLocastan3 = rhLocastan3Service.getById(id);

        return R.ok().put("rhLocastan3", rhLocastan3);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rhlocastan3:save")
    public R save(@RequestBody RhLocastan3Entity rhLocastan3){
		rhLocastan3Service.save(rhLocastan3);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rhlocastan3:update")
    public R update(@RequestBody RhLocastan3Entity rhLocastan3){
		rhLocastan3Service.updateById(rhLocastan3);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rhlocastan3:delete")
    public R delete(@RequestBody Integer[] ids){
		rhLocastan3Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
