package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RsBasedisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RsBasestanEntity;
import com.iapmhad.yhpostureadjust.service.RsBasestanService;
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
@RequestMapping("yhpostureadjust/rsbasestan")
public class RsBasestanController {
    @Autowired
    private RsBasestanService rsBasestanService;

    @RequestMapping("/getlast/{id}")
    public RsBasestanEntity getlast(@PathVariable("id") Integer id){
        List<RsBasestanEntity> last = rsBasestanService.getLi(id);
        if(last.size()!=0){
            RsBasestanEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rsbasestan:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rsBasestanService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rsbasestan:info")
    public R info(@PathVariable("id") Integer id){
		RsBasestanEntity rsBasestan = rsBasestanService.getById(id);

        return R.ok().put("rsBasestan", rsBasestan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rsbasestan:save")
    public R save(@RequestBody RsBasestanEntity rsBasestan){
		rsBasestanService.save(rsBasestan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rsbasestan:update")
    public R update(@RequestBody RsBasestanEntity rsBasestan){
		rsBasestanService.updateById(rsBasestan);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rsbasestan:delete")
    public R delete(@RequestBody Integer[] ids){
		rsBasestanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
