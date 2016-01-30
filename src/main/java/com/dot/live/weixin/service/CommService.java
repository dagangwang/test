package com.dot.live.weixin.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dot.live.weixin.domain.AccessToken;
import com.dot.live.weixin.domain.RecComTextMsg;
import com.dot.live.weixin.domain.RecEventSubMsg;
import com.dot.live.weixin.domain.ReplyNewsMsg;
import com.dot.live.weixin.domain.ReplyTextMsg;
import com.dot.live.weixin.enums.GuideType;
import com.dot.live.weixin.util.MessageUtil;



@Service("commService")
public class CommService {
	
	Logger logger = LoggerFactory.getLogger(CommService.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	RedisTemplate<String,Object> redisTemplate;
	
	/**
	 * 微信公众号后台->修改配置->提交（首次校验）
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @param wxtoken
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public String validate(String signature,String timestamp,String nonce,String echostr,String wxtoken) throws NoSuchAlgorithmException{
		
		String token = wxtoken;
		String valiStr = "";
		String[] array = new String[] { token, timestamp, nonce};
		StringBuffer sb = new StringBuffer();
		// 字符串排序
		Arrays.sort(array);
		for (int i = 0; i < 3; i++) {
			sb.append(array[i]);
		}
		String str = sb.toString();
		// SHA1签名生成
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(str.getBytes());
		byte[] digest = md.digest();
		StringBuffer hexstr = new StringBuffer();
		String shaHex = "";
		for (int i = 0; i < digest.length; i++) {
			shaHex = Integer.toHexString(digest[i] & 0xFF);
			if (shaHex.length() < 2) {
				hexstr.append(0);
			}
			hexstr.append(shaHex);
		}
		valiStr = hexstr.toString();
		if(valiStr.equals(signature)){
			return echostr;
		}else{
			return "";
		}
	}

	/**
	 * 消息处理
	 * @return
	 */	
	
    public String processRequest(HttpServletRequest request) {  
    	
    	
        String respMessage = null;  
        
        
        try {  
        	
            // 默认返回的文本消息内容  
            String respContent = "请求处理异常，请稍候尝试！";
            // xml请求解析  
            Map<String, String> requestMap = MessageUtil.parseXml(request);   
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
            
            logger.info("processRequest start  msgType:"+ msgType );
            // 回复文本消息  
            ReplyTextMsg textMessage = new ReplyTextMsg();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0);  
  
            // 文本消息  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {      	
            	
                respContent = "您发送的是文本消息！";              
                
                
            }  
            // 图片消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
                respContent = "您发送的是图片消息！";  
            }  
            // 地理位置消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respContent = "您发送的是地理位置消息！";  
            }  
            // 链接消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respContent = "您发送的是链接消息！";  
            }  
            // 音频消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                respContent = "您发送的是音频消息！";  
            }  
            // 事件推送  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // 事件类型  
                String eventType = requestMap.get("Event");  
                // 订阅  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                    respContent = "谢谢您的关注！";  
                }  
                // 取消订阅  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                }  
                // 自定义菜单点击事件  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                    // TODO 自定义菜单权没有开放，暂不处理该类消息  
                }  
            }  
            textMessage.setContent(respContent);  
            respMessage = MessageUtil.textMessageToXml(textMessage);  
            
        } catch (Exception e) {  
            e.printStackTrace(); 
            logger.info("Wexin message process Exceptiond");
        }  
  
        return respMessage;  
    }  
  	
	
	
//	/**
//	 * 获取微信默认入口（返回首次校验或正常回复）
//	 * @return
//	 */
//	public GuideType getGuideType(){
//		GuideType rs = (GuideType) redisTemplate.opsForValue().get("com:dot:live:weixin:entry");
//		return rs == null ? GuideType.REPLY : rs;
//	}
//	
//	/**
//	 * 设置微信默认入口（首次校验或正常回复）
//	 * @param type
//	 */
//	public void setGuideType(GuideType type){
//		redisTemplate.opsForValue().set("com:dot:live:weixin:entry", type);
//	}
//	

//	/**
//	 * 处理接收信息
//	 * @param msgBean
//	 * @return
//	 */
//	public String disposeRecMsg(Object msgBean,String fromUserName){
//		
//		if(msgBean instanceof RecComTextMsg){
//			return dispComTextMsg((RecComTextMsg)msgBean,fromUserName);
//		}
//		if(msgBean instanceof RecEventSubMsg){
//			return dispEventSubMsg((RecEventSubMsg)msgBean,fromUserName);
//		}
//		
//		return null;
//	}
//	
//	/*
//	 * 每小时执行一次
//	 * 
//	 */
//	@Scheduled(cron = "0 0 * * * ?") 
//	public void jobGenAccessToken(){
//		genAccessToken();
//	}
//	
//	public AccessToken manualGenAccessToken() throws Exception {
//		return genAccessToken();
//	}
//	
//	public AccessToken getAccessToken(){
//		return null;
//	}
//	
//	private AccessToken genAccessToken(){
//		return null;
//	}
//	
//	
//	public Error createMenu(String meunStr){
//		AccessToken token = getAccessToken();
//		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+token.getAccess_token();
//		HttpHeaders headers =new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<AccessToken> request=new HttpEntity<AccessToken>(token, headers);
//		Error er = restTemplate.postForObject(url, request, Error.class);
//		return er;
//	}
//	
//	
//	/**
//	 * 处理接收到的普通消息事件
//	 * @param msgBean
//	 * @return
//	 */
//	private String dispComTextMsg(RecComTextMsg msgBean, String fromUserName){
//		if(null != msgBean.getContent()){
//			String content = msgBean.getContent().trim();
//			logger.info("receive user info :"+ content);
//			if(content.length() >= 3 && content.substring(0, 3).equalsIgnoreCase("ykt")){
//				ReplyTextMsg rs = new ReplyTextMsg();
//				rs.setFromUserName(fromUserName);
//				rs.setToUserName(msgBean.getFromUserName());
//				rs.setCreateTime(msgBean.getCreateTime());
//				String link = "<a href=\"http://www.shunyilive.com/font/index.htm?openId="+msgBean.getFromUserName()+"\">点击即可查询一卡通账单</a>";
//				rs.setContent(link);
//				return rs.toString();
//			}
//		}
//		
//		//处理一卡通查询信息
//		ReplyNewsMsg news = new ReplyNewsMsg();
//		news.setCreateTime(msgBean.getCreateTime().toString());
//		news.setFromUserName(fromUserName);
//		news.setToUserName(msgBean.getFromUserName());
//		List<Article> articles = new ArrayList<Article>();
//		Article article = news.new Article();
//		article.setDescription("many delicious foot you can choose");
//		article.setPicUrl("http://www.shunyilive.com/img/food.jpg");
//		article.setTitle("shun yi DeliCity");
//		article.setUrl("http://www.shunyilive.com/food.jsp");
//		articles.add(article);
//		news.setArticles(articles);
//		return news.toString();
//	}
//	
//	
//	private String dispEventSubMsg(RecEventSubMsg msgBean,String fromUserName){
//		ReplyNewsMsg news = new ReplyNewsMsg();
//		news.setCreateTime(msgBean.getCreateTime().toString());
//		news.setFromUserName(fromUserName);
//		news.setToUserName(msgBean.getFromUserName());
//		List<Article> articles = new ArrayList<Article>();
//		Article article = news.new Article();
//		article.setDescription("直接输入：ykt 即可进行公交一卡通查询");
//		article.setPicUrl("http://www.shunyilive.com/resource/img/rs.png");
//		article.setTitle("公交地铁一卡通查询");
//		article.setUrl("http://www.shunyilive.com/font/index.do");
//		articles.add(article);
//		news.setArticles(articles);
//		return news.toString();
//	}
//	
//	
	
}
