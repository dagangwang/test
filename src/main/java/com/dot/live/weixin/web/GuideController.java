/**
 * 
 */
package com.dot.live.weixin.web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dot.live.weixin.constant.ServerConfig;
import com.dot.live.weixin.enums.GuideType;
import com.dot.live.weixin.service.CommService;

/**
 * @author hesq1
 * @date 2015年10月18日
 * @desc 主要负责将请求跳转到合适的WeiXinController方法上
 */
@Controller
@RequestMapping("/weixin")
public class GuideController {

	Logger logger = LoggerFactory.getLogger(GuideController.class); 
	
	@Autowired
	CommService commService;
	
//	@RequestMapping(value = "/guide")   
	public void guide(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String reqMethod = request.getMethod();
		
		if (reqMethod.equals("GET"))
		{
			logger.debug("Wexin request is  GET method");
	        String signature = request.getParameter("signature");  
	        String timestamp = request.getParameter("timestamp");  
	        String nonce = request.getParameter("nonce");  
	        String echostr = request.getParameter("echostr");  
	        String wxtoken =  ServerConfig.Token;   //"fangdedental20160101";   
	        String retEchostr = commService.validate(signature,timestamp,nonce, echostr, wxtoken);
	        PrintWriter out = response.getWriter();	
	        out.print(retEchostr);         
            out.close();  
            out = null;  
		    
		}else{
			logger.debug("Wexin request is  POST method");
	        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
	        request.setCharacterEncoding("UTF-8");  
	        response.setCharacterEncoding("UTF-8"); 	  
	        // 调用核心业务类接收消息、处理消息  
	        String respMessage = commService.processRequest(request);  	          
	        // 响应消息  
	        PrintWriter out = response.getWriter();  
	        out.print(respMessage);  
	        out.close();  			
			
		}
		
//		GuideType type = commService.getGuideType();
//		switch(type){
//	        case VALID:{
//	        	return "forward:/weixin/validate.do"; 
//	        }
//	        default:{
//	            return "forward:/weixin/reply.do";
//	        }
//		}
		
    }  
}
