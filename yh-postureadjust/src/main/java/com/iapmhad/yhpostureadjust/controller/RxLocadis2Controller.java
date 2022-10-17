package com.iapmhad.yhpostureadjust.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhpostureadjust.entity.RxLocadis1Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhpostureadjust.entity.RxLocadis2Entity;
import com.iapmhad.yhpostureadjust.service.RxLocadis2Service;
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
@RequestMapping("yhpostureadjust/rxlocadis2")
public class RxLocadis2Controller {
    @Autowired
    private RxLocadis2Service rxLocadis2Service;

    @RequestMapping("/getlast/{id}")
    public RxLocadis2Entity getlast(@PathVariable("id") Integer id){
        List<RxLocadis2Entity> last = rxLocadis2Service.getLi(id);
        if(last.size()!=0){
            RxLocadis2Entity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("yhpostureadjust:rxlocadis2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rxLocadis2Service.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhpostureadjust:rxlocadis2:info")
    public R info(@PathVariable("id") Integer id){
		RxLocadis2Entity rxLocadis2 = rxLocadis2Service.getById(id);

        return R.ok().put("rxLocadis2", rxLocadis2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhpostureadjust:rxlocadis2:save")
    public R save(@RequestBody RxLocadis2Entity rxLocadis2){
		rxLocadis2Service.save(rxLocadis2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhpostureadjust:rxlocadis2:update")
    public R update(@RequestBody RxLocadis2Entity rxLocadis2){
		rxLocadis2Service.updateById(rxLocadis2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhpostureadjust:rxlocadis2:delete")
    public R delete(@RequestBody Integer[] ids){
		rxLocadis2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
