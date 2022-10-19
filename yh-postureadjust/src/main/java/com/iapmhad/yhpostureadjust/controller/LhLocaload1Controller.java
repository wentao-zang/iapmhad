package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LhLocadis3Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LhLocaload1Entity;
import com.iapmhad.yhpostureadjust.service.LhLocaload1Service;
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
@RequestMapping("yhpostureadjust/lhlocaload1")
public class LhLocaload1Controller {
    @Autowired
    private LhLocaload1Service lhLocaload1Service;

    @RequestMapping("/getlast/{id}")
    public LhLocaload1Entity getlast(@PathVariable("id") Integer id){
        List<LhLocaload1Entity> last = lhLocaload1Service.getLi(id);
        if(last.size()!=0){
            LhLocaload1Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lhlocaload1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lhLocaload1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lhlocaload1:info")
    public R info(@PathVariable("id") Integer id){
		LhLocaload1Entity lhLocaload1 = lhLocaload1Service.getById(id);

        return R.ok().put("lhLocaload1", lhLocaload1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lhlocaload1:save")
    public R save(@RequestBody LhLocaload1Entity lhLocaload1){
		lhLocaload1Service.save(lhLocaload1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lhlocaload1:update")
    public R update(@RequestBody LhLocaload1Entity lhLocaload1){
		lhLocaload1Service.updateById(lhLocaload1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lhlocaload1:delete")
    public R delete(@RequestBody Integer[] ids){
		lhLocaload1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
