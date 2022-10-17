package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RxBasestanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RxLocadis1Entity;
import com.iapmhad.yhpostureadjust.service.RxLocadis1Service;
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
@RequestMapping("yhpostureadjust/rxlocadis1")
public class RxLocadis1Controller {
    @Autowired
    private RxLocadis1Service rxLocadis1Service;

    @RequestMapping("/getlast/{id}")
    public RxLocadis1Entity getlast(@PathVariable("id") Integer id){
        List<RxLocadis1Entity> last = rxLocadis1Service.getLi(id);
        if(last.size()!=0){
            RxLocadis1Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rxlocadis1:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rxLocadis1Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rxlocadis1:info")
    public R info(@PathVariable("id") Integer id){
		RxLocadis1Entity rxLocadis1 = rxLocadis1Service.getById(id);

        return R.ok().put("rxLocadis1", rxLocadis1);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rxlocadis1:save")
    public R save(@RequestBody RxLocadis1Entity rxLocadis1){
		rxLocadis1Service.save(rxLocadis1);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rxlocadis1:update")
    public R update(@RequestBody RxLocadis1Entity rxLocadis1){
		rxLocadis1Service.updateById(rxLocadis1);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rxlocadis1:delete")
    public R delete(@RequestBody Integer[] ids){
		rxLocadis1Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
