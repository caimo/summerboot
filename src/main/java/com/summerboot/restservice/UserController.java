package com.summerboot.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ias")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        System.out.println("新增数据：");
        return userService.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public boolean updateUser(@RequestBody User user, @RequestParam(value = "id", required = true) int Id) {
        System.out.println("更新数据：");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value = "id", required = true) int Id) {
        System.out.println("删除数据：");
        return userService.deleteUser(String.valueOf(Id));
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User findByUserName(@RequestParam(value = "userName", required = true) String userName) {
        System.out.println("查询数据：");
        return userService.findUserByName(userName);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findByUserAge() {
        System.out.println("查询所有数据:");
        return userService.findAll();
    }
}
