package com.summerboot.restservice.service;

import com.summerboot.restservice.model.User;
import com.summerboot.restservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserRepository userDao;

    @Override
    public boolean addUser(User user) {
        boolean flag = false;
        try {
            userDao.save(user);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateUser(User user) {
        boolean flag = false;
        try {
            userDao.save(user);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteUser(String id) {
        boolean flag = false;
        try {
            userDao.deleteById(id);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Optional<User> findUserByName(String userName) {

        // 创建查询条件数据对象
        User customer = new User();
        customer.setUsername(userName);

        // 创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());

        // 创建实例
        Example<User> ex = Example.of(customer, matcher);

        return userDao.findOne(ex);
    }

    @Override
    public Optional<User> findUserById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}

