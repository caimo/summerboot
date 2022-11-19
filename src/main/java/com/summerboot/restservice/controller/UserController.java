package com.summerboot.restservice.controller;

import com.summerboot.restservice.exception.ApiException;
import com.summerboot.restservice.exception.ExceptionEnum;
import com.summerboot.restservice.model.User;
import com.summerboot.restservice.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public boolean updateUser(@RequestBody User user, @PathVariable(value = "id") int Id) {
        System.out.println("更新数据：");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable(value = "id") int Id) {
        System.out.println("删除数据：");
        return userService.deleteUser(String.valueOf(Id));
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") String id) {
        System.out.println("查询数据：");
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new ApiException(ExceptionEnum.BUSINESS_ERROR_DATA_NOT_FOUND);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findAll(@RequestParam(value = "userName", required = false) String userName) {
        System.out.println("查询所有数据:");
        if (Strings.isNotBlank(userName)) {
            Optional<User> user = userService.findUserByName(userName);
            if (user.isPresent()) {
                return Collections.singletonList(user.get());
            }
        }
        return userService.findAll();
    }
}
