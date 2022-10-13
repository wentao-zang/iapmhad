package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LsLocadis1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RsLocaload1Entity;
import com.iapmhad.yhpostureadjust.service.RsLocaload1Service;
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
@RequestMapping("yhpostureadjust/rslocaload1")
public class RsLocaload1Controller {
    @Autowired
    private RsLocaload1Service rsLocaload1Service;

    @RequestMapping("/getlast/{id}")
    public RsLocaload1Entity getlast(@PathVariable("id") Integer id){
        List<RsLocaload1Entity> last = rsLocaload1Service.getLi(id);
        if(last.size()!=0){
            RsLocaload1Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rslocaload1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rsLocaload1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rslocaload1:info")
    public R info(@PathVariable("id") Integer id){
		RsLocaload1Entity rsLocaload1 = rsLocaload1Service.getById(id);

        return R.ok().put("rsLocaload1", rsLocaload1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rslocaload1:save")
    public R save(@RequestBody RsLocaload1Entity rsLocaload1){
		rsLocaload1Service.save(rsLocaload1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rslocaload1:update")
    public R update(@RequestBody RsLocaload1Entity rsLocaload1){
		rsLocaload1Service.updateById(rsLocaload1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rslocaload1:delete")
    public R delete(@RequestBody Integer[] ids){
		rsLocaload1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
