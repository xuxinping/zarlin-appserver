package com.veadan.userManage.userService;

import com.veadan.userManage.userDao.UserMapper;
import com.veadan.userManage.userModel.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Veadan on 2017/6/17.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserMapper UserMapper;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user=UserMapper.findUserAuthor(userName);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        String role=user.getRoleId();

        LOGGER.info("userNo----"+user.getUserNo());
        authorities.add(new SimpleGrantedAuthority(role));//此处设置用户角色为USER,只是为了简单对应起来

        LOGGER.info("ROLE------------"+role);
        return new org.springframework.security.core.userdetails.User(user.getUserNo(), user.getPassword(), authorities);
    }
}
