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
 * @ClassName: HomeController
 * @Description: 各页调用方法
 * @author lusiyu
 * @date 2016年7月26日
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController extends BaseController {
	@Autowired
	AlbumService albumService;
	@Autowired
	PhotoService photoservice;

	/**
	 * @Title: index
	 * @Autowired PhotoService photoservice;
	 * @Description: 进入相册管理页
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "home/index";
	}

	/**
	 * @Title: getAlbumList
	 * @Description: 获取相册列表
	 * @param page，albumList
	 * @return resMap
	 */
	@ResponseBody
	@RequestMapping(value = "/getAlbumList")
	public Map<String, Object> getAlbumList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> params = new HashMap<String, String>();// 分页参数
		Paginating page = getPaginating(request);
		this.loadPagination(params, page);
		List<AlbumVo> albumList = albumService.getAlbums(page.getPageIndex(),
				page.getPageSize());// 调取分页数
		int albumNum = albumService.queryAlbumNum();// 获取总数
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("rows", albumList);
		resMap.put("total", albumNum);
		resMap.put(Params.RET_CODE, albumList);
		return resMap;
	}

	/**
	 * @Title: searchPhoto
	 * @Description: 进入搜索照片页
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/searchPhoto")
	public String searchPhoto(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "home/searchPhoto";
	}

	/**
	 * @Title: photo
	 * @Description: 进入照片管理页（点击相册列表中的查看进人）
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/photo")
	public String photo(Model model, HttpServletRequest request)
			throws Exception {
		List<AlbumVo> albumvo = photoservice.getAlbumList();
		String albumid = request.getParameter("albumid");
		model.addAttribute("albumvo", albumvo);
		model.addAttribute("albumid", albumid);
		return "home/photo";
	}

	/**
	 * @Title: getPhotoList
	 * @Description: 获取照片列表
	 * @param request
	 * @return resMap
	 */
	@RequestMapping(value = "/getPhotoList")
	@ResponseBody
	public Map<String, Object> getPhotoList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String albumid = request.getParameter("albumid");
		Map<String, String> params = new HashMap<String, String>();
		// 分页参数
		Paginating page = getPaginating(request);
		this.loadPagination(params, page);
		List<PhotosVo> photoList = photoservice.getPhotosListByAlbumId(albumid,
				page.getPageIndex(), page.getPageSize());
		Map<String, Object> resMap = new HashMap<String, Object>();
		int photoNum = photoservice.getPhotosNumByAlbumId(albumid);
		resMap.put("rows", photoList);
		resMap.put("total", photoNum);
		return resMap;
	}

	/**
	 * @Title: user
	 * @Description: 进入个人页
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/user")
	public String user(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "home/user";
	}

	/**
	 * @Title: addAlbum
	 * @Description: 进入创建相册页
	 * @param albumName，albumDescribe
	 * @return resMap
	 */
	@RequestMapping(value = "/addAlbum")
	public String addAlbum(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "home/addAlbum";
	}

	@RequestMapping(value = "/addcolumn")
	@ResponseBody
	public Map<String, Object> addcolumn(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		Map<String, Object> resMap = new HashMap<String, Object>();
		String albumname = request.getParameter("albumName");
		String description = request.getParameter("albumDescribe");
	
			albumService.addAlbum(albumname, description);
			retMap.put("albumname", albumname);
			retMap.put("description", description);
	
			resMap.put(Params.RET_OBJ, retMap);
	
		return resMap;

	}

	/**
	 * @Title: addPhoto
	 * @Description: 进入添加照片页
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/addPhoto")
	public String addPhoto(Model model, HttpServletRequest request)
			throws Exception {
		List<AlbumVo> albumvo = photoservice.getAlbumList();
		model.addAttribute("albumvo", albumvo);
		return "home/addPhoto";
	}

	/**
	 * @Title: editAlbum（查找id）
	 * @Description: 进入编辑相册页
	 * @param albumid
	 * @return home/editAlbum
	 */
	@RequestMapping(value = "/editAlbum")
	public String editAlbum(HttpServletRequest request, Model model,
		HttpServletResponse response) throws Exception {
		String albumid = request.getParameter("albumid");
		Map<String, Object> queryIdAlbum = albumService.getAlbum(albumid);
		model.addAttribute("queryIdAlbum", queryIdAlbum);
		return "home/editAlbum";
	}


	/**
	 * @Title: updateAlbum
	 * @Description: 进入编辑相册页
	 * @param albumid，albumName，albumDescription
	 * @return resMap
	 */
	@RequestMapping(value = "/updateAlbum")
	@ResponseBody
	public Map<String, Object> update(HttpServletRequest request)
			throws Exception {
		String albumid = request.getParameter("albumid");
		String albumname = request.getParameter("albumName");
		String description = request.getParameter("albumDescription");
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap = albumService.updateAlbum(albumid, albumname, description);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(Params.RET_OBJ, retMap);
		return resMap;
	}

	/**
	 * @Title: deleteAlbum
	 * @Description: 进入编辑删除页
	 * @param albumid
	 * @return resMap
	 */

	@RequestMapping(value = "/deleteAlbum")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request)
			throws Exception {
		String albumid = request.getParameter("albumid");
		albumService.deleteAlbum(albumid);
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> retMap = new HashMap<String, Object>();
		resMap.put(Params.RET_CODE, "delete");
		resMap.put(Params.RET_OBJ, retMap);
		return resMap;
	}

	@RequestMapping(value = "/editPhoto")
	public String editPhoto(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "home/editPhoto";
	}

	/**
	 * @Title: viewPhoto
	 * @Description: 进入照片详情页
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/viewPhoto")
	public String viewPhoto(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String photoid = request.getParameter("photoid");
		Map<String, Object> photoInfo = photoservice.getPhoto(photoid);
		String photoname = (String) photoInfo.get("photoname");
		String description = (String) photoInfo.get("description");
		String screendate = (String) photoInfo.get("screendate");
		String phototype = (String) photoInfo.get("phototype");
		String albumid = (String) photoInfo.get("albumid");
		String albumname = photoservice.getAlbumNameByAlbumId(albumid);
		model.addAttribute("photoname", photoname);
		model.addAttribute("description", description);
		model.addAttribute("screendate", screendate);
		model.addAttribute("phototype", phototype);
		model.addAttribute("albumname", albumname);
		return "home/viewPhoto";
	}

	/**
	 * @Title: statistics
	 * @Description: 进入统计页
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/statistics")
	public String statistics(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "home/statistics";
	}
}
