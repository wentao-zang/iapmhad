package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RsBasestanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RsLocadis1Entity;
import com.iapmhad.yhpostureadjust.service.RsLocadis1Service;
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
@RequestMapping("yhpostureadjust/rslocadis1")
public class RsLocadis1Controller {
    @Autowired
    private RsLocadis1Service rsLocadis1Service;

    @RequestMapping("/getlast/{id}")
    public RsLocadis1Entity getlast(@PathVariable("id") Integer id){
        List<RsLocadis1Entity> last = rsLocadis1Service.getLi(id);
        if(last.size()!=0){
            RsLocadis1Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rslocadis1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rsLocadis1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rslocadis1:info")
    public R info(@PathVariable("id") Integer id){
		RsLocadis1Entity rsLocadis1 = rsLocadis1Service.getById(id);

        return R.ok().put("rsLocadis1", rsLocadis1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rslocadis1:save")
    public R save(@RequestBody RsLocadis1Entity rsLocadis1){
		rsLocadis1Service.save(rsLocadis1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rslocadis1:update")
    public R update(@RequestBody RsLocadis1Entity rsLocadis1){
		rsLocadis1Service.updateById(rsLocadis1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rslocadis1:delete")
    public R delete(@RequestBody Integer[] ids){
		rsLocadis1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
