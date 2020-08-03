package com.kj.mapper;

import com.kj.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层
 */
@Repository
public interface UserMapper {

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

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
     * 根据id查询一个用户
     * @param id
     * @return
     */
    User findById(Long id);

    List<User> findByCondition(String name);
}
