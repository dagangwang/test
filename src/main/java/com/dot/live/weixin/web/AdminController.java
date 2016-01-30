/**
 * 
 */
package com.dot.live.weixin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dot.live.weixin.domain.AccessToken;
import com.dot.live.weixin.enums.GuideType;
import com.dot.live.weixin.service.CommService;

/**
 * @author hesq1
 * @date 2015年10月18日
 * @desc 微信后台管理Controller
 */
@RestController 
@RequestMapping("/admin/weixin")
public class AdminController {
	
	Logger logger = LoggerFactory.getLogger(AdminController.class); 
	
	@Autowired
	CommService commService;
	
//	@RequestMapping(value = "/getGuideType")
//	public GuideType getGuideType(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		 return commService.getGuideType();
//	}
//	
//	@RequestMapping(value = "/setGuideType")
//	public GuideType setGuideType(HttpServletRequest request, HttpServletResponse response,GuideType type) throws Exception {
//		 commService.setGuideType(type);
//		 return type;
//	}
	
	//for admin back platform 
//	@RequestMapping(value = "/getToken")
//	public AccessToken getToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		 return commService.getAccessToken();
//	}
//	
//	@RequestMapping(value = "/genToken")
//	public AccessToken genToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		return commService.manualGenAccessToken();
//	}
//	
//	@RequestMapping(value = "/menu", method = RequestMethod.POST)
//	public Error createMenu(String menu){
//		return commService.createMenu(menu);
//	}

}
