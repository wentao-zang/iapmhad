package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LhLocaload1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LhLocaload2Entity;
import com.iapmhad.yhpostureadjust.service.LhLocaload2Service;
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
@RequestMapping("yhpostureadjust/lhlocaload2")
public class LhLocaload2Controller {
    @Autowired
    private LhLocaload2Service lhLocaload2Service;

    @RequestMapping("/getlast/{id}")
    public LhLocaload2Entity getlast(@PathVariable("id") Integer id){
        List<LhLocaload2Entity> last = lhLocaload2Service.getLi(id);
        if(last.size()!=0){
            LhLocaload2Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lhlocaload2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lhLocaload2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lhlocaload2:info")
    public R info(@PathVariable("id") Integer id){
		LhLocaload2Entity lhLocaload2 = lhLocaload2Service.getById(id);

        return R.ok().put("lhLocaload2", lhLocaload2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lhlocaload2:save")
    public R save(@RequestBody LhLocaload2Entity lhLocaload2){
		lhLocaload2Service.save(lhLocaload2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lhlocaload2:update")
    public R update(@RequestBody LhLocaload2Entity lhLocaload2){
		lhLocaload2Service.updateById(lhLocaload2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lhlocaload2:delete")
    public R delete(@RequestBody Integer[] ids){
		lhLocaload2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
