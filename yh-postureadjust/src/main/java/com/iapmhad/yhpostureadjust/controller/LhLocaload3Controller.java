package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LhLocaload2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.LhLocaload3Entity;
import com.iapmhad.yhpostureadjust.service.LhLocaload3Service;
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
@RequestMapping("yhpostureadjust/lhlocaload3")
public class LhLocaload3Controller {
    @Autowired
    private LhLocaload3Service lhLocaload3Service;

    @RequestMapping("/getlast/{id}")
    public LhLocaload3Entity getlast(@PathVariable("id") Integer id){
        List<LhLocaload3Entity> last = lhLocaload3Service.getLi(id);
        if(last.size()!=0){
            LhLocaload3Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:lhlocaload3:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lhLocaload3Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:lhlocaload3:info")
    public R info(@PathVariable("id") Integer id){
		LhLocaload3Entity lhLocaload3 = lhLocaload3Service.getById(id);

        return R.ok().put("lhLocaload3", lhLocaload3);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:lhlocaload3:save")
    public R save(@RequestBody LhLocaload3Entity lhLocaload3){
		lhLocaload3Service.save(lhLocaload3);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:lhlocaload3:update")
    public R update(@RequestBody LhLocaload3Entity lhLocaload3){
		lhLocaload3Service.updateById(lhLocaload3);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:lhlocaload3:delete")
    public R delete(@RequestBody Integer[] ids){
		lhLocaload3Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
