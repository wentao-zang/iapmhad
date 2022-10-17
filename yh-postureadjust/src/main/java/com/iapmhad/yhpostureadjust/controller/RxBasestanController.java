package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RxBasedisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RxBasestanEntity;
import com.iapmhad.yhpostureadjust.service.RxBasestanService;
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
@RequestMapping("yhpostureadjust/rxbasestan")
public class RxBasestanController {
    @Autowired
    private RxBasestanService rxBasestanService;

    @RequestMapping("/getlast/{id}")
    public RxBasestanEntity getlast(@PathVariable("id") Integer id){
        List<RxBasestanEntity> last = rxBasestanService.getLi(id);
        if(last.size()!=0){
            RxBasestanEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rxbasestan:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rxBasestanService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rxbasestan:info")
    public R info(@PathVariable("id") Integer id){
		RxBasestanEntity rxBasestan = rxBasestanService.getById(id);

        return R.ok().put("rxBasestan", rxBasestan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rxbasestan:save")
    public R save(@RequestBody RxBasestanEntity rxBasestan){
		rxBasestanService.save(rxBasestan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rxbasestan:update")
    public R update(@RequestBody RxBasestanEntity rxBasestan){
		rxBasestanService.updateById(rxBasestan);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rxbasestan:delete")
    public R delete(@RequestBody Integer[] ids){
		rxBasestanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
