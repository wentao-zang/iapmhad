package com.iapmhad.jydbjdj.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.jydbjdj.entity.JyLocadisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.jydbjdj.entity.JyLocaloadEntity;
import com.iapmhad.jydbjdj.service.JyLocaloadService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-10-20 15:50:00
 */
@RestController
@RequestMapping("jydbjdj/jylocaload")
public class JyLocaloadController {
    @Autowired
    private JyLocaloadService jyLocaloadService;

    @RequestMapping("/getlast/{id}")
    public JyLocaloadEntity getlast(@PathVariable("id") Integer id){
        List<JyLocaloadEntity> last = jyLocaloadService.getLi(id);
        if(last.size()!=0){
            JyLocaloadEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("jydbjdj:jylocaload:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jyLocaloadService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("jydbjdj:jylocaload:info")
    public R info(@PathVariable("id") Integer id){
		JyLocaloadEntity jyLocaload = jyLocaloadService.getById(id);

        return R.ok().put("jyLocaload", jyLocaload);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("jydbjdj:jylocaload:save")
    public R save(@RequestBody JyLocaloadEntity jyLocaload){
		jyLocaloadService.save(jyLocaload);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("jydbjdj:jylocaload:update")
    public R update(@RequestBody JyLocaloadEntity jyLocaload){
		jyLocaloadService.updateById(jyLocaload);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("jydbjdj:jylocaload:delete")
    public R delete(@RequestBody Integer[] ids){
		jyLocaloadService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
