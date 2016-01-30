package com.dot.live.weixin.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dot.live.weixin.aes.WXBizMsgCrypt;
import com.dot.live.weixin.constant.ServerConfig;
import com.dot.live.weixin.service.CommService;
import com.dot.live.weixin.util.ResMsgUtil;



@RestController 
@RequestMapping("/weixin")
public class FrontController {

	Logger logger = LoggerFactory.getLogger(FrontController.class); 
	
	@Autowired
	CommService commService;
	
//	//for first wx count validate
//	@RequestMapping(value = "/validate")   
//	public String validate(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String signature = request.getParameter("signature");
//		String timestamp = request.getParameter("timestamp");
//		String nonce = request.getParameter("nonce");
//		String echostr = request.getParameter("echostr");
//		return commService.validate(signature,timestamp,nonce,echostr,ServerConfig.Token);
//    }  
//	
//	//for second wx count reply 
//	@RequestMapping(value = "/reply")   
//	public String reply(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String timestamp = request.getParameter("timestamp");
//		String nonce = request.getParameter("nonce");
//		String encrypt_type = request.getParameter("encrypt_type");
//		String msg_signature = request.getParameter("msg_signature");
//		String postData = readStreamParameter(request.getInputStream());
//		if(null != encrypt_type && encrypt_type.equals("aes")){
//			WXBizMsgCrypt pc = new WXBizMsgCrypt(ServerConfig.Token, ServerConfig.EncodingAESKey, ServerConfig.AppID);
//			String data = pc.decryptMsg(msg_signature, timestamp, nonce, postData);
//			Object bean = ResMsgUtil.parseToBean(data);
//			String replyMsg = commService.disposeRecMsg(bean,ServerConfig.WXCode);
//			replyMsg = pc.encryptMsg(replyMsg, timestamp, nonce);
//			return replyMsg;
//		}
//		return "";
//	}
//	
//	
//	private String readStreamParameter(ServletInputStream in){  
//        StringBuilder buffer = new StringBuilder();  
//        BufferedReader reader=null;  
//        try{  
//            reader = new BufferedReader(new InputStreamReader(in));  
//            String line=null;  
//            while((line = reader.readLine())!=null){  
//                buffer.append(line);  
//            }  
//        }catch(Exception e){  
//            e.printStackTrace();  
//        }finally{  
//            if(null!=reader){  
//                try {  
//                    reader.close();  
//                } catch (IOException e) {  
//                    e.printStackTrace();  
//                }  
//            }  
//        }  
//        return buffer.toString();  
//    }  

}
