package com.iapmhad.jydbjdj.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.jydbjdj.entity.JyLocadisEntity;
import com.iapmhad.jydbjdj.service.JyLocadisService;
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
@RequestMapping("jydbjdj/jylocadis")
public class JyLocadisController {
    @Autowired
    private JyLocadisService jyLocadisService;

    @RequestMapping("/getlast/{id}")
    public JyLocadisEntity getlast(@PathVariable("id") Integer id){
        List<JyLocadisEntity> last = jyLocadisService.getLi(id);
        if(last.size()!=0){
            JyLocadisEntity last1 = last.get(last.size() - 1);
            return last1;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("jydbjdj:jylocadis:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = jyLocadisService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("jydbjdj:jylocadis:info")
    public R info(@PathVariable("id") Integer id){
		JyLocadisEntity jyLocadis = jyLocadisService.getById(id);

        return R.ok().put("jyLocadis", jyLocadis);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("jydbjdj:jylocadis:save")
    public R save(@RequestBody JyLocadisEntity jyLocadis){
		jyLocadisService.save(jyLocadis);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("jydbjdj:jylocadis:update")
    public R update(@RequestBody JyLocadisEntity jyLocadis){
		jyLocadisService.updateById(jyLocadis);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("jydbjdj:jylocadis:delete")
    public R delete(@RequestBody Integer[] ids){
		jyLocadisService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
