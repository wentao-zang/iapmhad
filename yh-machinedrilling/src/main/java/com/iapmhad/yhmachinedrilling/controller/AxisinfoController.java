package com.iapmhad.yhmachinedrilling.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.yhmachinedrilling.entity.ProductinfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.yhmachinedrilling.entity.AxisinfoEntity;
import com.iapmhad.yhmachinedrilling.service.AxisinfoService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-11 15:15:34
 */
@RestController
@RequestMapping("yhmachinedrilling/axisinfo")
public class AxisinfoController {
    @Autowired
    private AxisinfoService axisinfoService;

    /**
     * 列表
     */
    @RequestMapping("/getli/{id}")
    public List<AxisinfoEntity> getLi(@PathVariable("id") Integer id){
        List<AxisinfoEntity> list = axisinfoService.getLi(id);
        if(list.size()>300) {
            list = list.subList(list.size() - 300,list.size());
        }
//        list.forEach(System.out::println);
        return list;
    }

    @RequestMapping("/getlast/{id}")
    public AxisinfoEntity getlast(@PathVariable("id") Integer id){
        List<AxisinfoEntity> last = axisinfoService.getLi(id);
        if(last.size()!=0){
            AxisinfoEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    @RequestMapping("/list")
    //@RequiresPermissions("yhmachinedrilling:axisinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = axisinfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("yhmachinedrilling:axisinfo:info")
    public R info(@PathVariable("id") Integer id){
		AxisinfoEntity axisinfo = axisinfoService.getById(id);

        return R.ok().put("axisinfo", axisinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("yhmachinedrilling:axisinfo:save")
    public R save(@RequestBody AxisinfoEntity axisinfo){
		axisinfoService.save(axisinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("yhmachinedrilling:axisinfo:update")
    public R update(@RequestBody AxisinfoEntity axisinfo){
		axisinfoService.updateById(axisinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("yhmachinedrilling:axisinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		axisinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
