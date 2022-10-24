package com.iapmhad.jydbjdj.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.iapmhad.jydbjdj.entity.JyLocaloadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.jydbjdj.entity.JyLocastanEntity;
import com.iapmhad.jydbjdj.service.JyLocastanService;
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
@RequestMapping("jydbjdj/jylocastan")
public class JyLocastanController {
    @Autowired
    private JyLocastanService jyLocastanService;

    @RequestMapping("/getlast/{id}")
    public JyLocastanEntity getlast(@PathVariable("id") Integer id){
        List<JyLocastanEntity> last = jyLocastanService.getLi(id);
        if(last.size()!=0){
            JyLocastanEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("jydbjdj:jylocastan:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jyLocastanService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("jydbjdj:jylocastan:info")
    public R info(@PathVariable("id") Integer id){
		JyLocastanEntity jyLocastan = jyLocastanService.getById(id);

        return R.ok().put("jyLocastan", jyLocastan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("jydbjdj:jylocastan:save")
    public R save(@RequestBody JyLocastanEntity jyLocastan){
		jyLocastanService.save(jyLocastan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("jydbjdj:jylocastan:update")
    public R update(@RequestBody JyLocastanEntity jyLocastan){
		jyLocastanService.updateById(jyLocastan);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("jydbjdj:jylocastan:delete")
    public R delete(@RequestBody Integer[] ids){
		jyLocastanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
