package com.veadan.userManage.userDao;

import com.veadan.userManage.userModel.User;
import com.veadan.userManage.userModel.UserFunction;

import java.util.List;

/**
 * Created by Veadan on 2017/2/25.
 */

public interface UserMapper {

    /**
     * 认证获取用户名密码和权限信息
     * @param userNo
     * @return
     */
    public User findUserAuthor(String userNo);

    /**
     * userNo查询用户信息
     * @param userNo
     * @return
     */
    public User findUserByUserNo(String userNo);


    /**
     * 用户名密码登录接口
     * @return
     */

    public User loginByUserNoAndPassword(User user);

    /**
     * 图片修改
     */

    public void setUserImage(User user);
    /**
     * 用户名密码修改
     */
    public void updatePassword(User user);

    /**
     * 保管员刷卡登录
     * @param cardNo
     * @return
     */
    public List<User> loginByCardNo(String cardNo);


    /**
     * 刷卡获取工号信息
     * @param cardNo
     * @return
     */

    public List<User> findUserByCardNo(String cardNo);




    public List<UserFunction> findUserFunction(String function);

}
