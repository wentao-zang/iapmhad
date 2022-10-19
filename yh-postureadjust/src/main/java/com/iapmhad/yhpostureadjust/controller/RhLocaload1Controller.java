package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RhLocadis3Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RhLocaload1Entity;
import com.iapmhad.yhpostureadjust.service.RhLocaload1Service;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-19 22:02:25
 */
@RestController
@RequestMapping("yhpostureadjust/rhlocaload1")
public class RhLocaload1Controller {
    @Autowired
    private RhLocaload1Service rhLocaload1Service;

    @RequestMapping("/getlast/{id}")
    public RhLocaload1Entity getlast(@PathVariable("id") Integer id){
        List<RhLocaload1Entity> last = rhLocaload1Service.getLi(id);
        if(last.size()!=0){
            RhLocaload1Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rhlocaload1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rhLocaload1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rhlocaload1:info")
    public R info(@PathVariable("id") Integer id){
		RhLocaload1Entity rhLocaload1 = rhLocaload1Service.getById(id);

        return R.ok().put("rhLocaload1", rhLocaload1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rhlocaload1:save")
    public R save(@RequestBody RhLocaload1Entity rhLocaload1){
		rhLocaload1Service.save(rhLocaload1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rhlocaload1:update")
    public R update(@RequestBody RhLocaload1Entity rhLocaload1){
		rhLocaload1Service.updateById(rhLocaload1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rhlocaload1:delete")
    public R delete(@RequestBody Integer[] ids){
		rhLocaload1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
