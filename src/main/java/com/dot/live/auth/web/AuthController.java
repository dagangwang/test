/**
 * 
 */
package com.dot.live.auth.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hesq1
 * @date 2015年10月18日
 * @desc 
 */
@Controller
@RequestMapping("/adm")
public class AuthController {
	
	@RequestMapping(value = "/login")   
	public String login(HttpServletRequest request, HttpServletResponse response,String openId){
		return "adm/login";
    }
	
	
	@RequestMapping(value = "/index")   
	public String index(HttpServletRequest request, HttpServletResponse response,String openId){
		return "adm/index";
    } 

}
