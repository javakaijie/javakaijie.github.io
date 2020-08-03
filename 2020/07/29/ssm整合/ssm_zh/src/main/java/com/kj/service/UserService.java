package com.kj.service;

import com.github.pagehelper.PageInfo;
import com.kj.entity.User;

import java.util.List;

/**
 * 小哥
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询一个用户
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 添加一个用户
     * @param user 用户对象
     * @return
     */
    int addUser(User user);

    /**
     * 修改用户信息
     * @param user 用户对象
     * @return
     */
    int updateUser(User user);

    /**
     * 删除一个用户
     * @param id 用户编号
     * @return
     */
    int delUser(Long id);

    /**
     * 分页查询
     * @param pageNum 当前页码
     * @param pageSize 每页显示的条数
     * @return 分页信息对象
     */
    PageInfo<User> findByPage(Integer pageNum, Integer pageSize);

    List<User> findByCondition(String name);
}
