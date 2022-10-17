package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.LxLocastan2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RqLocadisEntity;
import com.iapmhad.yhpostureadjust.service.RqLocadisService;
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
@RequestMapping("yhpostureadjust/rqlocadis")
public class RqLocadisController {
    @Autowired
    private RqLocadisService rqLocadisService;

    @RequestMapping("/getlast/{id}")
    public RqLocadisEntity getlast(@PathVariable("id") Integer id){
        List<RqLocadisEntity> last = rqLocadisService.getLi(id);
        if(last.size()!=0){
            RqLocadisEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rqlocadis:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rqLocadisService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rqlocadis:info")
    public R info(@PathVariable("id") Integer id){
		RqLocadisEntity rqLocadis = rqLocadisService.getById(id);

        return R.ok().put("rqLocadis", rqLocadis);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rqlocadis:save")
    public R save(@RequestBody RqLocadisEntity rqLocadis){
		rqLocadisService.save(rqLocadis);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rqlocadis:update")
    public R update(@RequestBody RqLocadisEntity rqLocadis){
		rqLocadisService.updateById(rqLocadis);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rqlocadis:delete")
    public R delete(@RequestBody Integer[] ids){
		rqLocadisService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
