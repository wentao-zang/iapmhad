package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LxLocadis1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LxLocadis2Entity;
import com.iapmhad.yhpostureadjust.service.LxLocadis2Service;
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
@RequestMapping("yhpostureadjust/lxlocadis2")
public class LxLocadis2Controller {
    @Autowired
    private LxLocadis2Service lxLocadis2Service;

    @RequestMapping("/getlast/{id}")
    public LxLocadis2Entity getlast(@PathVariable("id") Integer id){
        List<LxLocadis2Entity> last = lxLocadis2Service.getLi(id);
        if(last.size()!=0){
            LxLocadis2Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lxlocadis2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lxLocadis2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lxlocadis2:info")
    public R info(@PathVariable("id") Integer id){
		LxLocadis2Entity lxLocadis2 = lxLocadis2Service.getById(id);

        return R.ok().put("lxLocadis2", lxLocadis2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lxlocadis2:save")
    public R save(@RequestBody LxLocadis2Entity lxLocadis2){
		lxLocadis2Service.save(lxLocadis2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lxlocadis2:update")
    public R update(@RequestBody LxLocadis2Entity lxLocadis2){
		lxLocadis2Service.updateById(lxLocadis2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lxlocadis2:delete")
    public R delete(@RequestBody Integer[] ids){
		lxLocadis2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
