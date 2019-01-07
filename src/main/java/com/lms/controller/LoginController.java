package com.lms.controller;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;

import com.lms.po.*;
import com.lms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@Controller
public class LoginController {

    @Autowired
    DefaultKaptcha defaultKaptcha;

    @Autowired
    LoginService loginService;
    @Autowired
    RoleService roleService;
    /**
     * 跳转到登录页面
     **/
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        return "login";
    }
    /**
    *注销
     */
    @RequestMapping("log_off")
    @ResponseBody
    public String log_off(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("userId");
        session.removeAttribute("userName");
        session.removeAttribute("roleId");
        session.removeAttribute("roleName");
        session.removeAttribute("menu");
        session.removeAttribute("menuList");
        return "true";
    }
    /**
     * 登录
     */
    @RequestMapping("/submit")
    @ResponseBody
        public String loginSubmit(@RequestParam(value = "userid") String userid, @RequestParam(value = "password") String password, HttpServletRequest request){
        HttpSession session = request.getSession();
        Student ss = loginService.loginStudentFind(userid,password);
        Teacher tt = loginService.loginTeacherFind(userid,password);

        if(ss!=null){
            System.out.println(ss.toString());
            session.setAttribute("userId",ss.getStudentNo());
            session.setAttribute("userName",ss.getStudentName());
            session.setAttribute("roleType",ss.getRoleId());
            session.setAttribute("roleName",roleService.loginRoleFind(ss.getRoleId()));
            session.setAttribute("menuList",roleService.findByRoleIdString(ss.getRoleId()));
            System.out.println(ss.getRoleId());
            return "true";
        }if(tt!=null){
            System.out.println(tt.toString());
            session.setAttribute("userId",tt.getTeacherNo());
            session.setAttribute("userName",tt.getTeacherName());
            session.setAttribute("roleType",tt.getRoleId());
            session.setAttribute("roleName",roleService.loginRoleFind(tt.getRoleId()));
            session.setAttribute("menuList",roleService.findByRoleIdString(tt.getRoleId()));
            return "true";
        }else{
            System.out.println("没得!");
            return "error";
        }
    }
/**
 * 生成验证码
 **/
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    /**
     * 验证输入验证码是否正确
     */
    @RequestMapping(value = "/imgvrifyControllerDefaultKaptcha",method = RequestMethod.GET)
    @ResponseBody
    public String imgvrifyControllerDefaultKaptcha(@RequestParam String parameter, HttpServletRequest httpServletRequest) {
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        String par = parameter;
        if (!captchaId.equals(par)) {
            return "false";
        } else {
            return "true";
        }
    }
    }
