package com.iapmhad.ame_hdym.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iapmhad.ame_hdym.entity.UsersEntity;
import com.iapmhad.ame_hdym.service.UsersService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;



/**
 * 
 *
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-09-15 11:02:30
 */
@RestController
@RequestMapping("ame_hdym/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = usersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		UsersEntity users = usersService.getById(id);

        return R.ok().put("users", users);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UsersEntity users){
		usersService.save(users);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UsersEntity users){
		usersService.updateById(users);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		usersService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
