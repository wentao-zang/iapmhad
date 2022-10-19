package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RhLocaload1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RhLocaload2Entity;
import com.iapmhad.yhpostureadjust.service.RhLocaload2Service;
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
@RequestMapping("yhpostureadjust/rhlocaload2")
public class RhLocaload2Controller {
    @Autowired
    private RhLocaload2Service rhLocaload2Service;

    @RequestMapping("/getlast/{id}")
    public RhLocaload2Entity getlast(@PathVariable("id") Integer id){
        List<RhLocaload2Entity> last = rhLocaload2Service.getLi(id);
        if(last.size()!=0){
            RhLocaload2Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rhlocaload2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rhLocaload2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rhlocaload2:info")
    public R info(@PathVariable("id") Integer id){
		RhLocaload2Entity rhLocaload2 = rhLocaload2Service.getById(id);

        return R.ok().put("rhLocaload2", rhLocaload2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rhlocaload2:save")
    public R save(@RequestBody RhLocaload2Entity rhLocaload2){
		rhLocaload2Service.save(rhLocaload2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rhlocaload2:update")
    public R update(@RequestBody RhLocaload2Entity rhLocaload2){
		rhLocaload2Service.updateById(rhLocaload2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rhlocaload2:delete")
    public R delete(@RequestBody Integer[] ids){
		rhLocaload2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
