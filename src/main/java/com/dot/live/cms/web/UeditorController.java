/**
 * 
 */
package com.dot.live.cms.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author hesq1
 * @date 2015年11月13日
 * @desc
 */
@RestController
@RequestMapping("/admin/editor")
public class UeditorController {

	Logger logger = LoggerFactory.getLogger(UeditorController.class);
	
	private static final String REAL_PATH = "/upload/image";

	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public Object getConfig(String action) {
//		JSONObject config = new JSONObject();
//		if ("config".equals(action)) {
			//设置上传文件名
//			config.put("imageFieldName", "files");
			//设置上传路径
//			config.put("imageUrl", "/admin/ueditor/upload.do");
//			config.put("imagePath", "/view/source/ueditor/");
//			config.put("imageMaxSize", 2048);
//			config.put("imageAllowFiles", JSONArray.parse("[\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"]"));
//			return config;
//		} else {
//			return "";
//		}
		return JSONObject.parse("{\"snapscreenInsertAlign\":\"none\",\"videoPathFormat\":\"/ueditor/jsp/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}\",\"videoFieldName\":\"upfile\",\"fileManagerActionName\":\"listfile\",\"fileUrlPrefix\":\"\",\"imageUrlPrefix\":\"\",\"imageAllowFiles\":[\".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\"],\"videoAllowFiles\":[\".flv\",\".swf\",\".mkv\",\".avi\",\".rm\",\".rmvb\",\".mpeg\",\".mpg\",\".ogg\",\".ogv\",\".mov\",\".wmv\",\".mp4\",\".webm\",\".mp3\",\".wav\",\".mid\"],\"filePathFormat\":\"/ueditor/jsp/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}\",\"fileMaxSize\":51200000,\"fileManagerListPath\":\"/ueditor/jsp/upload/file/\",\"catcherUrlPrefix\":\"\",\"videoActionName\":\"uploadvideo\",\"scrawlInsertAlign\":\"none\",\"videoUrlPrefix\":\"\",\"imageManagerUrlPrefix\":\"\",\"scrawlUrlPrefix\":\"\",\"imageFieldName\":\"upfile\",\"fileManagerAllowFiles\":[\".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\",\".flv\",\".swf\",\".mkv\",\".avi\",\".rm\",\".rmvb\",\".mpeg\",\".mpg\",\".ogg\",\".ogv\",\".mov\",\".wmv\",\".mp4\",\".webm\",\".mp3\",\".wav\",\".mid\",\".rar\",\".zip\",\".tar\",\".gz\",\".7z\",\".bz2\",\".cab\",\".iso\",\".doc\",\".docx\",\".xls\",\".xlsx\",\".ppt\",\".pptx\",\".pdf\",\".txt\",\".md\",\".xml\"],\"imageMaxSize\":2048000,\"catcherPathFormat\":\"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\"imageManagerInsertAlign\":\"none\",\"scrawlFieldName\":\"upfile\",\"imagePathFormat\":\"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\"scrawlActionName\":\"uploadscrawl\",\"imageManagerActionName\":\"listimage\",\"imageActionName\":\"uploadimage\",\"imageManagerListSize\":20,\"imageManagerAllowFiles\":[\".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\"],\"fileAllowFiles\":[\".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\",\".flv\",\".swf\",\".mkv\",\".avi\",\".rm\",\".rmvb\",\".mpeg\",\".mpg\",\".ogg\",\".ogv\",\".mov\",\".wmv\",\".mp4\",\".webm\",\".mp3\",\".wav\",\".mid\",\".rar\",\".zip\",\".tar\",\".gz\",\".7z\",\".bz2\",\".cab\",\".iso\",\".doc\",\".docx\",\".xls\",\".xlsx\",\".ppt\",\".pptx\",\".pdf\",\".txt\",\".md\",\".xml\"],\"snapscreenActionName\":\"uploadimage\",\"fileFieldName\":\"upfile\",\"fileActionName\":\"uploadfile\",\"catcherActionName\":\"catchimage\",\"fileManagerListSize\":20,\"catcherAllowFiles\":[\".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\"],\"snapscreenPathFormat\":\"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\"imageCompressBorder\":1600,\"snapscreenUrlPrefix\":\"\",\"imageCompressEnable\":true,\"catcherLocalDomain\":[\"127.0.0.1\",\"localhost\",\"img.baidu.com\"],\"imageManagerListPath\":\"/ueditor/jsp/upload/image/\",\"imageInsertAlign\":\"none\",\"catcherMaxSize\":2048000,\"videoMaxSize\":102400000,\"fileManagerUrlPrefix\":\"\",\"scrawlPathFormat\":\"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\"scrawlMaxSize\":2048000,\"catcherFieldName\":\"source\"}");
	}

	@RequestMapping(value = "/upload")
	public String addUser(@RequestParam MultipartFile[] upload,int CKEditorFuncNum,  HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String originalFilename = null;
		String realpath = null;
		String filePath = null;
		String fileName = null;
		String url = null;
		for (MultipartFile file : upload) {
			if (file.isEmpty()) {
				return "请选择文件后上传";
			} else {
				originalFilename = file.getOriginalFilename();
				filePath = genFilePath();
				realpath = request.getSession().getServletContext().getRealPath(filePath);
				fileName = genFileName(originalFilename);
				url = request.getContextPath()+filePath+"/"+fileName;
				JSONObject info = new JSONObject();
				info.put("文件原名", originalFilename);
				info.put("文件名称", file.getName());
				info.put("文件长度", file.getSize());
				info.put("文件类型", file.getContentType());
				logger.info(info.toJSONString());
				try {
					// 这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
					// 此处也可以使用Spring提供的MultipartFile.transferTo(File
					// dest)方法实现文件的上传
					FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realpath, fileName));
				} catch (IOException e) {
					logger.error(new JSONObject().put("文件原名", originalFilename + "上传失败").toString());
					e.printStackTrace();
					return "上传失败";
				}
			}
		}
		StringBuffer rs = new StringBuffer();
		rs.append("<script type=\"text/javascript\">");
		rs.append("window.parent.CKEDITOR.tools.callFunction("+ CKEditorFuncNum + ",'" + url + "','')");
		rs.append("</script>");
//		rs.put("original", originalFilename);
//		rs.put("name", fileName);
//		rs.put("url", url);
//		rs.put("state", "SUCCESS");
		return rs.toString();
	}
	
	private String genFilePath(){
		Calendar cal = Calendar.getInstance();
		return REAL_PATH + "/" +cal.get(Calendar.YEAR) + "/" +cal.get(Calendar.MONTH);
	}
	
	
	private String genFileName(String fileName) { 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String time = sdf.format(new Date()); 
        int position = fileName.lastIndexOf(".");  
        String extension = fileName.substring(position);
        return time + extension;  
    }  

}
