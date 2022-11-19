package com.summerboot.restservice.service;

import com.summerboot.restservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    boolean updateUser(User user);


    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    boolean deleteUser(String id);

    /**
     * 根据名字查询用户信息
     *
     * @param userName
     */
    Optional<User> findUserByName(String userName);

    /**
     * 根据名字查询用户信息
     *
     * @param id
     */
    Optional<User> findUserById(String id);


    /**
     * 查询所有数据
     *
     * @return
     */
    List<User> findAll();
}