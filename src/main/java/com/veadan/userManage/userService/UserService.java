package com.veadan.userManage.userService;


import com.veadan.config.resultFormat.JsonResult;
import com.veadan.config.resultFormat.EnumCode;
import com.veadan.userManage.userModel.User;
import com.veadan.userManage.userDao.UserMapper;
import com.veadan.userManage.userModel.UserFunction;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/**
 * 用户服务接口实现
 * Created by Veadan on 2017/2/25.
 */

@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper UserMapper;

    @Autowired
    private Environment env;


    public JsonResult login(User us) {
        //User us=new User();
       // us.setUserNo(userNo);
       // us.setPassword(password);
       User user=UserMapper.loginByUserNoAndPassword(us);
        if(user==null){

            return new JsonResult(EnumCode.FAILED,"登录失败",null);
        }else{

            return new JsonResult(EnumCode.SUCCESS,"登录成功",user);
        }

    }
/*

    */
/**
     * 刷卡登录
     * @param cardNo
     * @param request
     * @return
     */


    public JsonResult loginByCardNo(String cardNo,HttpServletRequest request) throws MalformedURLException {
        List user=UserMapper.loginByCardNo(cardNo);
        HashMap<String, Object> ret = new HashMap<String, Object>();
        if(user.isEmpty()){
            return new JsonResult(EnumCode.FAILED,"登录失败");
        }else{
            User user1= (User) user.get(0);
            String url1=user1.getImage();
            String userNo1=user1.getUserNo();
            String serverPath = new URL(request.getScheme(), request.getServerName(), request.getServerPort(),
                    request.getContextPath()).toString();
            ret.put("urlN", serverPath +"/"+"userImage/native/"+url1);
            ret.put("urlM", serverPath +"/"+"userImage/mini/"+url1);
            user1.setUrl(ret);
            return new JsonResult(EnumCode.SUCCESS,"登录成功",user1);
        }
    }



    /**
     * 用户头像上传
     * @param file
     * @param request
     * @return
     */
    @Transactional
    public JsonResult uploadImage(MultipartFile file, HttpServletRequest request) throws MalformedURLException {
        User user = getCurrentUser(request);
            HashMap<String, Object> ret = new HashMap<String, Object>();
            if (file != null) {
                if (!file.isEmpty()) {
                    try {
                        byte[] bytes = file.getBytes();
                        // 当前app根目录
                        String rootPath = request.getServletContext().getRealPath("/");

                        // 原生版保存路径 需要上传的相对地址（application.properties中获取 ）
                        String nativeRelativePath = env.getProperty("image.file.upload.dir.n")+user.getUserNo();

                        //压缩版保存路径
                        String miniRelativePath = env.getProperty("image.file.upload.dir.m")+user.getUserNo();

                        // 文件夹是否存在，不存在就创建
                        File dirN = new File("D:" + File.separator +nativeRelativePath);
                        if (!dirN.exists())
                            dirN.mkdirs();

                        // 文件夹是否存在，不存在就创建
                        File dirM = new File("D:" + File.separator +miniRelativePath);
                        if (!dirM.exists())
                            dirM.mkdirs();

                       // String fileExtension = getFileExtension(file);

                        String filename = file.getOriginalFilename();

                        String relativeFile = user.getUserNo() +"/"+ filename;  //保存至数据库
                        //file.transferTo(dest);
                        // 保存图片
                        File serverNativeFile = new File("D:/userImage/native/"+user.getUserNo()+"/"+filename);

                        File serverMiniFile = new File("D:/userImage/mini/"+user.getUserNo()+"/"+filename);

                        try {
                            // 先尝试压缩并保存图片
                            Thumbnails.of(file.getInputStream()).scale(1f).outputQuality(0.1f).toFile(serverMiniFile);
                        } catch (IOException e) {
                            try {
                                // 失败了再用springmvc自带的方式
                                file.transferTo(serverMiniFile);
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }

                        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverNativeFile));
                        stream.write(bytes);
                        stream.close();

                        LOGGER.info("NATIVE_DIR = " + serverMiniFile.getAbsolutePath());

                        String serverPath = new URL(request.getScheme(), request.getServerName(), request.getServerPort(),
                                request.getContextPath()).toString();
                        ret.put("urlN", serverPath +"/"+"userImage/native/"+user.getUserNo()+"/"+filename);
                        ret.put("urlM", serverPath +"/"+env.getProperty("image.file.upload.dir.m")+user.getUserNo()+"/"+filename);

                        User us=new User();
                        us.setImage(relativeFile);
                        us.setUserNo(user.getUserNo());
                        UserMapper.setUserImage(us);

                    } catch (Exception e) {
                        LOGGER.info("error: {}", e);
                        ret.put("urlN", "none");
                    }
                }
            }

            if(ret.get("urlN")=="none"){
                return new JsonResult(EnumCode.FAILED,"上传失败",ret);

            }else{

                return  new JsonResult(EnumCode.SUCCESS,"上传成功",ret);
            }



    }

    public JsonResult getUserFunction(HttpServletRequest request) throws MalformedURLException {

        String f =getCurrentUser(request).getFunction();

        List<UserFunction> function =UserMapper.findUserFunction(f);

        if(function.isEmpty()){


            return new JsonResult(EnumCode.FAILED,"获取失败");
        }else {

            return new JsonResult(function.size(),EnumCode.SUCCESS,"获取成功",function);
        }

    }



    /**
     * 获取当前用户信息
     * @param request
     * @return
     * @throws MalformedURLException
     */
    public User getCurrentUser(HttpServletRequest request) throws MalformedURLException {
       User user= UserMapper.findUserByUserNo(getCurrentUserNo());
        HashMap<String, Object> ret = new HashMap<String, Object>();
        String url=user.getImage();
        if(url!=null){
        String serverPath = new URL(request.getScheme(), request.getServerName(), request.getServerPort(),
                request.getContextPath()).toString();

        ret.put("urlN", serverPath +"/"+"userImage/native/"+url);
        ret.put("urlM", serverPath +"/"+"userImage/mini/"+url);
        user.setUrl(ret);
        }
        return user;
    }


    public String getCurrentUserNo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name=auth.getName();
        if(name==""){

            return "1232";
        }else{
        LOGGER.info("当前用户----------------"+name);
        return name;
        }
}


    public JsonResult findUserByCardNo(String cardNo) {
        List user=UserMapper.findUserByCardNo(cardNo);
        if(user.isEmpty()){

            return new JsonResult(EnumCode.FAILED,"刷卡失败");
        }else{

            return new JsonResult(EnumCode.SUCCESS,"刷卡成功",user);
        }
    }

    public JsonResult updatePassword(String userNo,String passwordOld,String passwordNew){
        User us=new User();
        User us2=new User();
        us.setUserNo(userNo);
        us.setPassword(passwordOld);

        User user=UserMapper.loginByUserNoAndPassword(us);

        if (user==null){

            return new JsonResult(EnumCode.FAILED,"用户名或密码错误");
        }else{
            us2.setUserNo(userNo);us2.setPassword(passwordNew);
            UserMapper.updatePassword(us2);

            return new JsonResult(EnumCode.SUCCESS,"密码修改登录成功");
        }


    }


}
