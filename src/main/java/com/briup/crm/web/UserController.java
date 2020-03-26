package com.briup.crm.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briup.crm.bean.SysUser;
import com.briup.crm.service.UserService;

@Controller

public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username ,String password,HttpSession session) {
			String url="";
			try {
				SysUser user = userService.login(username, password);
				url= "index";
				session.setAttribute("user", user);
			} catch (Exception e) {
				String msg = e.getMessage();
				session.setAttribute("msg", msg);
				url= "login";
			}
		return url;
	}
	//退出登录
	@RequestMapping("/logout")
	public String  logout(HttpSession session) {
		//将用户的信息从session中清除
		session.removeAttribute("user");
		return "login";
	}
}
