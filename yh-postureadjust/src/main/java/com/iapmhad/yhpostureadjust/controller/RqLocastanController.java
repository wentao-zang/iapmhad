package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RqLocadisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RqLocastanEntity;
import com.iapmhad.yhpostureadjust.service.RqLocastanService;
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
@RequestMapping("yhpostureadjust/rqlocastan")
public class RqLocastanController {
    @Autowired
    private RqLocastanService rqLocastanService;

    @RequestMapping("/getlast/{id}")
    public RqLocastanEntity getlast(@PathVariable("id") Integer id){
        List<RqLocastanEntity> last = rqLocastanService.getLi(id);
        if(last.size()!=0){
            RqLocastanEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rqlocastan:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rqLocastanService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rqlocastan:info")
    public R info(@PathVariable("id") Integer id){
		RqLocastanEntity rqLocastan = rqLocastanService.getById(id);

        return R.ok().put("rqLocastan", rqLocastan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rqlocastan:save")
    public R save(@RequestBody RqLocastanEntity rqLocastan){
		rqLocastanService.save(rqLocastan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rqlocastan:update")
    public R update(@RequestBody RqLocastanEntity rqLocastan){
		rqLocastanService.updateById(rqLocastan);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rqlocastan:delete")
    public R delete(@RequestBody Integer[] ids){
		rqLocastanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
