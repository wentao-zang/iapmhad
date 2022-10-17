package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LxLocaload1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LxLocaload2Entity;
import com.iapmhad.yhpostureadjust.service.LxLocaload2Service;
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
@RequestMapping("yhpostureadjust/lxlocaload2")
public class LxLocaload2Controller {
    @Autowired
    private LxLocaload2Service lxLocaload2Service;

    @RequestMapping("/getlast/{id}")
    public LxLocaload2Entity getlast(@PathVariable("id") Integer id){
        List<LxLocaload2Entity> last = lxLocaload2Service.getLi(id);
        if(last.size()!=0){
            LxLocaload2Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lxlocaload2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lxLocaload2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lxlocaload2:info")
    public R info(@PathVariable("id") Integer id){
		LxLocaload2Entity lxLocaload2 = lxLocaload2Service.getById(id);

        return R.ok().put("lxLocaload2", lxLocaload2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lxlocaload2:save")
    public R save(@RequestBody LxLocaload2Entity lxLocaload2){
		lxLocaload2Service.save(lxLocaload2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lxlocaload2:update")
    public R update(@RequestBody LxLocaload2Entity lxLocaload2){
		lxLocaload2Service.updateById(lxLocaload2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lxlocaload2:delete")
    public R delete(@RequestBody Integer[] ids){
		lxLocaload2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
