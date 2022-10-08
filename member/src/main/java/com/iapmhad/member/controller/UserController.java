package com.iapmhad.member.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import com.iapmhad.member.entity.UserEntity;
import com.iapmhad.member.service.UserService;
import com.iapmhad.common.utils.PageUtils;
import com.iapmhad.common.utils.R;

import javax.servlet.http.HttpServletRequest;


/**
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-03-09 13:18:45
 */
@RestController
@RefreshScope
@RequestMapping("member/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/authentication/{username}")
    public Character authentication(@PathVariable("username") String username) {

        UserEntity user = userService.verify(username);
        if(user!=null){
            return user.getPrivilegeId();
        }
        System.out.println(user);
        return null;
    }



    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = userService.queryPage(params);

        return R.ok().put("page", page);
    }


    /*
1、获取全部用户
2、遍历是否存在改用户
3、返回该用户或者null
*/
//    @RequestMapping("/verify/{username}")
//    public UserEntity verify(@PathVariable("username") String username,HttpServletRequest request) {
//        UserEntity user = userService.verify(username);
//        String token=request.getParameter("user");
//        return user;
//    }
    @RequestMapping("/verify")
    public R verify(@RequestParam(name="username",required = false) String username,@RequestParam(name="password",required = false) String password) {
        UserEntity user = userService.verify(username);
        if(user!=null&&user.getPassword().equals(password)){
            System.out.println(user);
            UserEntity user1 = new UserEntity();
            user1.setUsername("zq");
            user1.setPassword("abc123");
            user1.setPrivilegeId('A');
            user1.setGender(true);
            userService.save(user1);

            return R.ok().put("user1",user1);
        }
        System.out.println(user);
        return R.error("账号密码错误");
    }


    @RequestMapping("/saveU")
    public Object saveU(@RequestBody UserEntity user) {
        userService.save(user);
        return R.ok();
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Integer userId) {
        UserEntity user = userService.getById(userId);
        return R.ok().put("user", user);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UserEntity user) {
        userService.save(user);

        return R.ok();
    }

    /**
     * 修改
     */
//    @RequestMapping("/update/{username}/{password}/{privilegeId}")
//    public Object update(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("privilegeId") String privilegeId) {
//        UserEntity user= verify(username);
//        if(user==null){
//            return "账号不存在";
//        }else {
//            user.setPassword(password);
//            user.setPrivilegeId(privilegeId);
//            userService.updateById(user);
//            return "修改成功";
//        }
//
//    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] userIds) {
        userService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }


}
