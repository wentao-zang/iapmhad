package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LhLocastan2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LhLocastan3Entity;
import com.iapmhad.yhpostureadjust.service.LhLocastan3Service;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-17 18:27:30
 */
@RestController
@RequestMapping("yhpostureadjust/lhlocastan3")
public class LhLocastan3Controller {
    @Autowired
    private LhLocastan3Service lhLocastan3Service;

    @RequestMapping("/getlast/{id}")
    public LhLocastan3Entity getlast(@PathVariable("id") Integer id){
        List<LhLocastan3Entity> last = lhLocastan3Service.getLi(id);
        if(last.size()!=0){
            LhLocastan3Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lhlocastan3:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lhLocastan3Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lhlocastan3:info")
    public R info(@PathVariable("id") Integer id){
		LhLocastan3Entity lhLocastan3 = lhLocastan3Service.getById(id);

        return R.ok().put("lhLocastan3", lhLocastan3);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lhlocastan3:save")
    public R save(@RequestBody LhLocastan3Entity lhLocastan3){
		lhLocastan3Service.save(lhLocastan3);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lhlocastan3:update")
    public R update(@RequestBody LhLocastan3Entity lhLocastan3){
		lhLocastan3Service.updateById(lhLocastan3);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lhlocastan3:delete")
    public R delete(@RequestBody Integer[] ids){
		lhLocastan3Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
