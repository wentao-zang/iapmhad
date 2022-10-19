package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RhLocaload2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RhLocaload3Entity;
import com.iapmhad.yhpostureadjust.service.RhLocaload3Service;
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
@RequestMapping("yhpostureadjust/rhlocaload3")
public class RhLocaload3Controller {
    @Autowired
    private RhLocaload3Service rhLocaload3Service;

    @RequestMapping("/getlast/{id}")
    public RhLocaload3Entity getlast(@PathVariable("id") Integer id){
        List<RhLocaload3Entity> last = rhLocaload3Service.getLi(id);
        if(last.size()!=0){
            RhLocaload3Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rhlocaload3:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rhLocaload3Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rhlocaload3:info")
    public R info(@PathVariable("id") Integer id){
		RhLocaload3Entity rhLocaload3 = rhLocaload3Service.getById(id);

        return R.ok().put("rhLocaload3", rhLocaload3);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rhlocaload3:save")
    public R save(@RequestBody RhLocaload3Entity rhLocaload3){
		rhLocaload3Service.save(rhLocaload3);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rhlocaload3:update")
    public R update(@RequestBody RhLocaload3Entity rhLocaload3){
		rhLocaload3Service.updateById(rhLocaload3);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rhlocaload3:delete")
    public R delete(@RequestBody Integer[] ids){
		rhLocaload3Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
