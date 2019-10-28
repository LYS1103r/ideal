package com.qf.controller;

import com.qf.entity.User;
import com.qf.service.SubjectService;
import com.qf.service.UserService;
import com.qf.videos.utils.ImageCut;
import com.qf.videos.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SubjectService subjectService;
//    @Autowired
//    private MailUtils mailUtils;


    @RequestMapping("/loginUser")
    public void login(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String data=userService.loginUser(user);
        User user1=userService.getUserLogin(user);

        request.getSession().setAttribute("user",user1);
        request.getSession().setAttribute("userAccount",user1.getEmail());
        request.getSession().setAttribute("userid",user1.getId());
        request.getSession().setAttribute("email",user1.getEmail());
        response.getWriter().print(data);
    }

    /*@RequestMapping("/loginAccount")
    public String loginAcount(HttpServletRequest request){
        String email = (String)request.getSession().getAttribute("email");
        request.getSession().setAttribute("Account",email);
        return "redirect:/index/login";
    }
*/
    @RequestMapping("/forgetPassword")
    public String forgetPassword(){
        return "before/forget_password";
    }


    //更改头像
    @RequestMapping("/changeAvatar")
    public String changeAvatar() {

        return "before/change_avatar";
    }

    //上传头像
    @RequestMapping("/upLoadImage")
    public String upLoadImage(MultipartFile image_file,String x1,String y1,String w,String h,HttpServletRequest request) throws IOException, MessagingException {
        System.out.println(image_file);
        System.out.println("x:"+x1+" y:"+y1+" w:"+w+" "+h);

        // 上传的位置
        String path = "D:\\tomcat\\apache-tomcat-9.0.24-windows-x64-file\\apache-tomcat-9.0.24\\webapps\\uploadfile\\images\\";

        // 判断，该路径是否存在
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdirs();
        }
        // 说明上传文件项
        // 获取上传文件的名称
        String filename = image_file.getOriginalFilename();
        System.out.println(filename);

        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        // 完成文件上传
        image_file.transferTo(new File(path,filename));

        //裁剪图片
        double a=Double.parseDouble(x1);
        double b=Double.parseDouble(y1);
        ImageCut imageCut=new ImageCut();
        imageCut.cutImage(path+filename,(int)a,(int)b,Integer.parseInt(w),Integer.parseInt(h));

        //保存到数据库
        Object email = request.getSession().getAttribute("email");
        User user=new User();
        user.setEmail(email.toString());
        user.setImgUrl(filename);
        userService.updateUserImage1(user);
        request.getSession().setAttribute("user",userService.getUpdateUser1(email.toString()));

        return "redirect:changeAvatar";
    }

    //更改资料
    @RequestMapping("/changeProfile")
    public String changeProfile() {
        return "before/change_profile";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user,HttpServletRequest request) {
        userService.updateUser(user);
        //Object userid = request.getSession().getAttribute("userid");
        User user1=userService.getUpdateUser(user.getId());
        request.getSession().setAttribute("user",user1);
        return "redirect:/index/user/showMyProfile";
    }

    //更改密码
    @RequestMapping("/passwordSafe")
    public String passwordSafe() {
        return "before/password_safe";
    }

    @RequestMapping("/validatePassword")
    public void validatePassword(String password,HttpServletResponse response,HttpServletRequest request) throws IOException {
        Object userid = request.getSession().getAttribute("userid");
        if (userid!=null){
            if(password.equals(userService.getpassword((Integer) userid))){
                response.getWriter().print("success");
            }
        }
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(String newPassword,HttpServletRequest request) {
        Object userid = request.getSession().getAttribute("userid");
        if (userid!=null){
            User user=new User();
            user.setPassword(newPassword);
            user.setId((Integer) userid);
            userService.updatePassword(user);
        }
        request.getSession().removeAttribute("userAccount");
        return "redirect:/index/login";
    }




    //退出个人中心
    @RequestMapping("/loginOut2")
    public String loginOut2() {

        return "redirect:/index/login";
    }

    //退出登录
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request,Model model) {
        System.out.println("进入方法体1");
        request.getSession().removeAttribute("userAccount");
        model.addAttribute("subjectList",subjectService.getAll());
        System.out.println("进入方法体2");
        return "before/index";
    }

    @RequestMapping("/showMyProfile")
    public String showMyProfile(HttpServletRequest request) {
        //request.getSession().setAttribute("userAccount","");
        //request.getSession().removeAttribute("userAccount");
        //request.getSession().removeAttribute("sessionScope");
        //return "redirect:/index/user/showMyProfile";
        //before/index
        return "before/my_profile";
    }

    //////////////////邮箱验证/////////////
    @RequestMapping("/sendEmail")
    public void sendEmail(String email,HttpServletResponse response) throws IOException {
        System.out.println(email);
        Integer count=userService.sendEmail(email);
        if(count>0){
            response.getWriter().print("success");
            String code=MailUtils.getValidateCode(6);
            User user=new User();
            user.setEmail(email);
            user.setCode(code);
            userService.userCode(user);
            MailUtils.sendMail(email, "你好，这是一封测试邮件，无需回复。", "Y先生的验证码是：" + code);
        }else{
            response.getWriter().print("hasNoUser");
        }
    }

    @RequestMapping("/validateEmailCode")
    public String validateEmailCode(User user, Model model){
        Integer integer = userService.validateEmailCode(user);
        if (integer>0){
            model.addAttribute("email",user.getEmail());
            return "before/reset_password";
        }else{
            return "before/forget_password";
        }

    }

    @RequestMapping("/resetPassword")
    public String resetPassword(User user){
        user.setCode(UUID.randomUUID().toString().substring(0, 6));
        userService.resetPassword(user);
        return "redirect:/index/login";
    }


    //////////////--------------注册-----------//////////////
    @RequestMapping("/validateEmail")
    public  void validateEmail(HttpServletResponse response,String email) throws IOException {
        System.out.println(email);
        Integer integer=userService.validateEmail(email);
        String data=null;
        if(integer<1){
            data="success";
        }
        response.getWriter().print(data);
    }

    @RequestMapping("/insertUser")
    public void insertUser(HttpServletResponse response,HttpServletRequest request,String email,String password) throws IOException {
        System.out.println("表现层邮箱："+email);
        System.out.println("表现层密码："+password);
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.insertUser(user);
        request.getSession().setAttribute("user",userService.getRegUser(user));
        request.getSession().setAttribute("userAccount",user.getEmail());
        request.getSession().setAttribute("email",user.getEmail());
        response.getWriter().print("success");
    }

}
