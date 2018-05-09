package com.neusoft.neumooc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.core.common.conf.Params;
import com.neusoft.core.util.MD5Util;
import com.neusoft.neumooc.service.UserService;


/** 
 * @ClassName: UserController 
 * @Description: TODO 用户管理类
 * @author huangruijin
 * @date 2016年7月26日
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired UserService userService;

	/** 
	 * @Title: editPassword 
	 * @Description: TODO 进入修改密码页面
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/editPassword")
	public String editPassword(HttpServletRequest request, HttpServletResponse response){
		return "home/user";
	}
	
	
	/** 
	 * @Title: editPasswordAJAX 
	 * @Description: TODO 修改用户密码
	 * @param request
	 * @return boolean
	 */
	@ResponseBody
	@RequestMapping(value = "editPasswordAjax")
	public Map<String, Object> editPasswordAjax(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession(true);
		String userName = session.getAttribute(Params.SESSION_ATTR_KEY_USER).toString();
		String oldPass = request.getParameter("oldPassword");
		String newPass = request.getParameter("newPassword");
		String oldPassMD5 = MD5Util.gen(oldPass.getBytes());
		String newPassMD5 = MD5Util.gen(newPass.getBytes());
		boolean b = userService.updatePass(userName, oldPassMD5, newPassMD5);
		Map<String, Object> resMap = new HashMap<String, Object>();
		if(b){
			resMap.put(Params.RET_CODE, Params.RET_CODE_SUCCESS);
			resMap.put(Params.RET_OBJ, "修改密码成功");
		} else {// 封装返回值 用户名或密码错误
			resMap.put(Params.RET_CODE, Params.RET_CODE_ERROR);
			resMap.put(Params.RET_OBJ, "旧密码错误，请重新输入");
		}
		return resMap;
	}
}
