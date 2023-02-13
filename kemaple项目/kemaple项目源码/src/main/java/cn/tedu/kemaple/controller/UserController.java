package cn.tedu.kemaple.controller;

import cn.tedu.kemaple.entity.User;
import cn.tedu.kemaple.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;

    @RequestMapping("/login")
    public int login(@RequestBody User user){
        System.out.println("user = " + user);
        User u=mapper.selectByUsername(user.getUsername());
        if(u!=null){
            if(user.getPassword().equals(u.getPassword())){
                return 1;
            }
            return 2;
        }
        return 3;
    }

}
