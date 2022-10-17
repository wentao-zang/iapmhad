package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LsLocaload1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LsLocaload2Entity;
import com.iapmhad.yhpostureadjust.service.LsLocaload2Service;
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
@RequestMapping("yhpostureadjust/lslocaload2")
public class LsLocaload2Controller {
    @Autowired
    private LsLocaload2Service lsLocaload2Service;

    @RequestMapping("/getlast/{id}")
    public LsLocaload2Entity getlast(@PathVariable("id") Integer id){
        List<LsLocaload2Entity> last = lsLocaload2Service.getLi(id);
        if(last.size()!=0){
            LsLocaload2Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lslocaload2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lsLocaload2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lslocaload2:info")
    public R info(@PathVariable("id") Integer id){
		LsLocaload2Entity lsLocaload2 = lsLocaload2Service.getById(id);

        return R.ok().put("lsLocaload2", lsLocaload2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lslocaload2:save")
    public R save(@RequestBody LsLocaload2Entity lsLocaload2){
		lsLocaload2Service.save(lsLocaload2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lslocaload2:update")
    public R update(@RequestBody LsLocaload2Entity lsLocaload2){
		lsLocaload2Service.updateById(lsLocaload2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lslocaload2:delete")
    public R delete(@RequestBody Integer[] ids){
		lsLocaload2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
