package com.xin.web;

import com.xin.entity.User;
import com.xin.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by CHENXINXIN on 2016/6/28.
 */
@RestController
public class HelloController {
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser(@RequestParam(value = "id") Long id){
        User user = userService.getUser(id);
        return user;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public User myHttpPost(@RequestBody User user){
        System.out.println("success");
        System.out.println("user.getName() = " + user.getName());
        String name = user.getName();
        System.out.println(StringUtils.isNotBlank(name));
        if (name==null){
            System.out.println("name==null");
        }else {
            System.out.println(name.equals(""));
            System.out.println(StringUtils.isBlank(name));
            System.out.println(StringUtils.isEmpty(name));
        }
        return user;
    }
}
