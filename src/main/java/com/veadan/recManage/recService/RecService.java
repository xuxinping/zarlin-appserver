package com.veadan.recManage.recService;

import com.veadan.config.resultFormat.EnumCode;
import com.veadan.config.resultFormat.JsonResult;
import com.veadan.recManage.recDao.RecMapper;
import com.veadan.userManage.userDao.UserMapper;
import com.veadan.recManage.recModel.RecList;
import com.veadan.userManage.userModel.User;
import com.veadan.userManage.userService.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by Veadan on 2017/6/18.
 */

@Service
public class RecService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecService.class);
    @Autowired
    private RecMapper recMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    public PageInfo<RecList> findRecListByWhere(int page,int size,RecList recList, HttpServletRequest request) throws MalformedURLException {
       User user=userService.getCurrentUser(request);
       String invPhysic=user.getOrganizationId();

        LOGGER.info("-----------------------------------"+invPhysic);
       recList.setInvPhysic(invPhysic);

        PageHelper.startPage(page,size,true);
      List list= recMapper.findRecListBy(recList);
        PageInfo<RecList> pageInfo=new PageInfo<>(list);
      return pageInfo;

    }


    public JsonResult findRecSuppList(HttpServletRequest request) throws MalformedURLException {

        User user=userService.getCurrentUser(request);
        String invPhysic=user.getOrganizationId();

        List list=recMapper.findRecSuppList(invPhysic);

        if(list.isEmpty()){

            return new JsonResult(EnumCode.FAILED,"获取失败");

        }else {

            return new JsonResult(list.size(),EnumCode.SUCCESS,"获取成功",list);
        }

    }


}
