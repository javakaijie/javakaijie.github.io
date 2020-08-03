package com.kj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kj.entity.User;
import com.kj.mapper.UserMapper;
import com.kj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 小哥
 * UserService实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 根据id查询一个用户
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    /**
     * 添加一个用户
     *
     * @param user 用户对象
     * @return
     */
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    /**
     * 修改用户信息
     *
     * @param user 用户对象
     * @return
     */
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    /**
     * 删除一个用户
     *
     * @param id 用户编号
     * @return
     */
    @Override
    public int delUser(Long id) {
        return userMapper.delUser(id);
    }

    /**
     * 分页查询
     *
     * @param pageNum  当前页码
     * @param pageSize 每页显示的条数
     * @return 分页信息对象
     */
    @Override
    public PageInfo<User> findByPage(Integer pageNum, Integer pageSize) {
        //启动分页
        PageHelper.startPage(pageNum,pageSize);
        //查询所有的用户信息
        List<User> users = userMapper.findAll();
        //封装分页对象
        PageInfo<User> pageInfo = new PageInfo<>(users);
        //返回数据
        return pageInfo;
    }

    @Override
    public List<User> findByCondition(String name) {
        return userMapper.findByCondition(name);
    }
}
