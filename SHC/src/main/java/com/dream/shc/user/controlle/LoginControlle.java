package com.dream.shc.user.controlle;

import java.io.File;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dream.shc.base.controlle.BaseController;
import com.dream.shc.main.constants.MainConstants;
import com.dream.shc.main.dao.GridFSDao;
import com.dream.shc.sys.util.StringUtil;
import com.dream.shc.sys.util.SystemUtil;
import com.dream.shc.user.dao.UserDao;
import com.dream.shc.user.document.User;

@Controller
@RequestMapping(value = "/page")
public class LoginControlle extends BaseController{
	@Autowired
	private UserDao userDao;
	@Autowired
	private GridFSDao gridFSDao;
	
	
	@RequestMapping(value = "/login")
	public String login(User user,Model model,HttpSession session)throws Exception {
		user.setId("ddd");
		userDao.save(user);
		//userDao.createCollection();
		if(user!=null&&StringUtil.stringIsNotEmpty(user.getAccount())&&StringUtil.stringIsNotEmpty(user.getPassword())){
			//user = userDao.get("sss");
			model.addAttribute("user",user);
			return "index.jsp";
		}else{
			model.addAttribute("user",user);
			model.addAttribute("message","用户名或密码不能为空！");
			return "WEB-INF/jsp/main/login.jsp";
		}
	}
	
	@RequestMapping(value = "/main")
	public String main(User user,Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response)throws Exception {
//		String ip = SystemUtil.getIpAddress(request);
//		System.out.println(ip);
//		for(Cookie ck:request.getCookies()){
//			System.out.println(ck.getName()+":"+ck.getValue());
//		}
		//Cookie ck = new Cookie("testSHC", "aaaaa");
		//response.addCookie(ck);
		//System.out.println("mac:"+SystemUtil.getMACAddress(ip));
		return "example/example";
	}
	/**
	 * 查询并返回用户
	 * 2013-8-2
	 * User
	 */
	@RequestMapping(value = "/getUser")
	@ResponseBody
	public User main(User user,Model model)throws Exception {
		if(user!=null){
			user = userDao.get(user.getId());
		}
		return user;
	}
	/**
	 * 查询并返回用户
	 * 2013-8-2
	 * User
	 */
	@RequestMapping(value = "/toRegisterPage")
	public String toRegisterPage(Model model)throws Exception {
		return "example/file_upload";
	}
	
	/**
	 * 查询并返回用户
	 * 2013-8-2
	 * User
	 */
	@RequestMapping(value = "/register")
	public String register(User user,Model model)throws Exception {
		user.setAccount("test999");
		user.setAccount("张某某1");
		user.setPassword("654321");
		userDao.save(user);
		if(user.getPhotoFile()!=null){
			gridFSDao.saveFile(user.getPhotoFile().getInputStream(),user.getPhotoFile().getName(),MainConstants.FILE_TYPE_PHOTO);
		}
		
		return "example/example";
	}
	
	@RequestMapping(value = "/toUpload")
	public String toUpload(Model model)throws Exception {
		return "example/mvc_upload";
	}
	@RequestMapping(value="/upload")
	public void upload(@RequestParam MultipartFile[] files, HttpServletRequest request){
		for(MultipartFile file:files) {
			if(file.isEmpty()){ 
				continue;
			}
			System.out.println(file.getContentType()+","+file.getName()+","+file.getOriginalFilename());
		}
	}
}
