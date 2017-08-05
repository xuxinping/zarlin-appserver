package com.veadan.userManage.userController;

import com.veadan.config.resultFormat.JsonResult;
import com.veadan.config.resultFormat.EnumCode;
import com.veadan.userManage.userModel.User;
import com.veadan.userManage.userService.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;

/**
 * Created by Veadan on 2017/2/25.
 */


@RestController
@RequestMapping("/api/v1/user")
@Api(value ="保管员用户信息",description = "该接口包含登录，用户信息获取，刷卡登录，密码修改")
public class userController {

    private static final Logger LOGGER = LoggerFactory.getLogger(userController.class);
    @Autowired
    private UserService userService;
   /**
     * 刷卡登陆接口
     * @param cardNo
     * @return
     */

    @ApiOperation(value = "保管员刷卡登录", notes = "GET请求方式，通过卡号（cardNo）获取保管员用户信息")
    @GetMapping (value = "/loginByCardNo/{cardNo}",produces = "application/json")
    public JsonResult loginByCardNo(@PathVariable("cardNo") String cardNo,HttpServletRequest request) throws MalformedURLException {
        return userService.loginByCardNo(cardNo,request);
    }

    /**
     * 刷卡获取员工信息
     * @param cardNo
     * @return
     */
    @ApiOperation(value = "刷卡获取员工信息", notes = "GET请求方式，通过卡号（cardNo）获取保管员用户信息")
    @GetMapping (value = "/findByCardNo/{cardNo}",produces = "application/json")
    public JsonResult findUserByCardNo(@PathVariable("cardNo") String cardNo){
        return userService.findUserByCardNo(cardNo);
    }
    /**
     * 获取当前登陆
     * @param
     * @return
     */
    @ApiOperation(value = "获取当前登录用户", notes = "GET请求方式，")
    @GetMapping (value = "/findCurrentUser",produces = "application/json")
    public JsonResult findCurrentUser(HttpServletRequest request) throws MalformedURLException {
        User user = userService.getCurrentUser(request);

        if(user!=null){


            return new JsonResult(EnumCode.SUCCESS,"当前用户信息",user);
        }else {

            return new JsonResult(EnumCode.FAILED,"无用户登录");
        }
    }



    @ApiOperation(value = "获取登录用户功能列表", notes = "GET请求方式，")
    @GetMapping (value = "/getFunction",produces = "application/json")
    public JsonResult findUserFunction(HttpServletRequest request) throws MalformedURLException {
       return userService.getUserFunction(request);

    }


    /**
     * 用户名密码登录接口
     * @return
     */
    @ApiOperation(value = "保管员用户登录", notes = "POS请求方式，需要验证userNo&password，WHPD01表")
    @PostMapping(value = "/login",produces = "application/json")
    public JsonResult login(User user) {

        return userService.login(user);

    }


    /**
     * 密码修改接口
     * @param userNo
     * @param passwordOld
     * @param passwordNew
     * @return
     */
    @ApiOperation(value = "保管员密码修改",notes = "用户名，旧密码，新密码")
    @RequestMapping(value = "/update/{userNo}/{passwordOld}/{passwordNew}",method = RequestMethod.POST,produces = "application/json")
    public JsonResult updatePassword(@PathVariable("userNo") String userNo,
                                     @PathVariable("passwordOld") String passwordOld,
                                     @PathVariable("passwordNew") String passwordNew){

        return userService.updatePassword(userNo,passwordOld,passwordNew);
    }


    /**
     * 用户头像上传接口
     * @param file
     * @param request
     * @return
     */
    @ApiOperation(value = "用户头像上传",notes = "头像上传")
    @PostMapping(value = "/setUserImage")
    public JsonResult setUserImage(@RequestParam MultipartFile file, HttpServletRequest request) throws MalformedURLException {
        return userService.uploadImage(file,request);
    }

}
