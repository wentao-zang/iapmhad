package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LhLocadis2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LhLocadis3Entity;
import com.iapmhad.yhpostureadjust.service.LhLocadis3Service;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-17 18:27:31
 */
@RestController
@RequestMapping("yhpostureadjust/lhlocadis3")
public class LhLocadis3Controller {
    @Autowired
    private LhLocadis3Service lhLocadis3Service;

    @RequestMapping("/getlast/{id}")
    public LhLocadis3Entity getlast(@PathVariable("id") Integer id){
        List<LhLocadis3Entity> last = lhLocadis3Service.getLi(id);
        if(last.size()!=0){
            LhLocadis3Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lhlocadis3:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lhLocadis3Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lhlocadis3:info")
    public R info(@PathVariable("id") Integer id){
		LhLocadis3Entity lhLocadis3 = lhLocadis3Service.getById(id);

        return R.ok().put("lhLocadis3", lhLocadis3);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lhlocadis3:save")
    public R save(@RequestBody LhLocadis3Entity lhLocadis3){
		lhLocadis3Service.save(lhLocadis3);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lhlocadis3:update")
    public R update(@RequestBody LhLocadis3Entity lhLocadis3){
		lhLocadis3Service.updateById(lhLocadis3);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lhlocadis3:delete")
    public R delete(@RequestBody Integer[] ids){
		lhLocadis3Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
