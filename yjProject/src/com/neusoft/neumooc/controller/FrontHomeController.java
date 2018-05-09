package com.neusoft.neumooc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.neusoft.core.common.BaseController;
import com.neusoft.core.common.conf.Params;
import com.neusoft.core.common.pagination.Paginating;
import com.neusoft.neumooc.service.AlbumService;
import com.neusoft.neumooc.vo.AlbumVo;
import com.neusoft.neumooc.service.PhotoService;
import com.neusoft.neumooc.vo.PhotosVo;

/**
 * @ClassName: FrontHomeController
 * @Description: 各页调用方法
 * @author yezhenchi
 * @date 2016年7月26日
 */
@Controller
@RequestMapping(value = "/front")
public class FrontHomeController extends BaseController {
	@Autowired
	AlbumService albumService;
	@Autowired
	PhotoService photoservice;

	/**
	 * @Title: index
	 * @Autowired ;
	 * @Description: 进入前端首页
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "home/frontIndex";
	}

}
