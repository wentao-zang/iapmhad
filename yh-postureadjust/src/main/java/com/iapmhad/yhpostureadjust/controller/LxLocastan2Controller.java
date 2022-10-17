package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LxLocaload2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LxLocastan2Entity;
import com.iapmhad.yhpostureadjust.service.LxLocastan2Service;
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
@RequestMapping("yhpostureadjust/lxlocastan2")
public class LxLocastan2Controller {
    @Autowired
    private LxLocastan2Service lxLocastan2Service;

    @RequestMapping("/getlast/{id}")
    public LxLocastan2Entity getlast(@PathVariable("id") Integer id){
        List<LxLocastan2Entity> last = lxLocastan2Service.getLi(id);
        if(last.size()!=0){
            LxLocastan2Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lxlocastan2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lxLocastan2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lxlocastan2:info")
    public R info(@PathVariable("id") Integer id){
		LxLocastan2Entity lxLocastan2 = lxLocastan2Service.getById(id);

        return R.ok().put("lxLocastan2", lxLocastan2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lxlocastan2:save")
    public R save(@RequestBody LxLocastan2Entity lxLocastan2){
		lxLocastan2Service.save(lxLocastan2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lxlocastan2:update")
    public R update(@RequestBody LxLocastan2Entity lxLocastan2){
		lxLocastan2Service.updateById(lxLocastan2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lxlocastan2:delete")
    public R delete(@RequestBody Integer[] ids){
		lxLocastan2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
