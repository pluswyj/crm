package com.briup.crm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	@RequestMapping({"/","/toLogin"})
	public String toLogin() {
		return "login";
	}
}
