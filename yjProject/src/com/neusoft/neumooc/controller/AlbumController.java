package com.neusoft.neumooc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.core.common.BaseController;
import com.neusoft.core.common.conf.Params;
import com.neusoft.core.common.exception.DAOException;
import com.neusoft.core.util.Util;
import com.neusoft.neumooc.service.AlbumService;
import com.neusoft.neumooc.vo.AlbumVo;

/**
 * @ClassName: AlbumController
 * @Description: 相册增加，修改，删除
 * @author Fuyongjun
 * @date 2016年7月25日
 */ 

@Controller
@RequestMapping(value = "/album")
public class AlbumController extends BaseController {
	@Autowired
	AlbumService albumService;

	/**
	 * @Title: index
	 * @Autowired
	 * @Description: 进入相册主页
	 * @param pageNo
	 *            ，pageSize
	 * @return resMap
	 */
	@RequestMapping(value = "/getPagining")
	public String Pagining(HttpServletRequest request) {
		return "Album/getAlbumId";
	}

	
	/** 
	 * @Title: Pagining 
	 * @Description: 获得相册列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pagining")
	@ResponseBody
	public Map<String, Object> Pagining(HttpServletRequest request,
			HttpServletResponse response) {
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			pageNo = pageNo == null ? "1" : pageNo;
			pageSize = pageSize == null ? "10" : pageSize;
			int pageIndex = (Util.parseInt(pageNo) - 1) * Util.parseInt(pageSize);
			int albumNum = albumService.queryAlbumNum();
			List<AlbumVo> albumList = albumService.getAlbums(pageIndex,
					Util.parseInt(pageSize));
			
			retMap.put("albumNum", albumNum);
			retMap.put("albumList", albumList);
			resMap.put(Params.RET_OBJ, retMap);
		} catch (DAOException e) {
			log.debug("显示相册列表抛出的异常信息是:" + e.getMessage());
		}
		return resMap;
	}

	/**
	 * @Title: index
	 * @Autowired
	 * @Description: 插入列表
	 * @param albumname
	 *            ，description
	 * @return resMap
	 */
	@RequestMapping(value = "/add")
	public String addcolumns(HttpServletRequest request,
			HttpServletResponse response) {
		return "Album/add";
	}

	@RequestMapping(value = "/addcolumn")
	@ResponseBody
	public Map<String, Object> addcolumn(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> retMap = new HashMap<String, Object>();
		String albumname = request.getParameter("albumname");
		String description = request.getParameter("description");
		try {
			albumService.addAlbum(albumname, description);
			retMap.put("albumname", albumname);
			retMap.put("description", description);
			resMap.put(Params.RET_OBJ, retMap);

		} catch (Exception e) {
			log.debug("添加相册抛出的异常信息是:" + e.getMessage());
		}
		return resMap;
	}

	
	/** 
	 * @Title: add 
	 * @Description: 到添加相册页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryone")
	public String add(HttpServletRequest request) {
		return "Album/queryone";
	}

	/**
	 * @Title: 查询id
	 * @Autowired
	 * @Description: 获取id
	 * @param albumid 相册id
	 * @return resMap
	 */
	@RequestMapping(value = "/queryId")
	@ResponseBody
	public Map<String, Object> getAlbum(HttpServletRequest request) {
		String albumid = request.getParameter("albumid");
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {

			retMap = albumService.getAlbum(albumid);
		} catch (Exception e) {
			log.debug("查询相册的id抛出异常:" + e.getMessage());
		}

		if (retMap != null) {
			resMap.put(Params.RET_OBJ, retMap);
		}
		return resMap;
	}

	/**
	 * @Title: 更新信息
	 * @Autowired
	 * @Description:
	 * @param albumid
	 *            ，albumname，description
	 * @return resMap
	 */
	@RequestMapping(value = "/update")
	public String updatecolumns(HttpServletRequest request) {
		return "Album/update";
	}

	
	/** 
	 * @Title: updateAlbum 
	 * @Description: 更新相册
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updatecolumn")
	@ResponseBody
	public Map<String, Object> updateAlbum(HttpServletRequest request) {
		String albumid = request.getParameter("albumid");
		String albumname = request.getParameter("albumname");
		String description = request.getParameter("description");
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			retMap = albumService.updateAlbum(albumid, albumname, description);
			resMap.put(Params.RET_OBJ, retMap);
		} catch (Exception e) {
			log.debug("更新相册抛出的异常信息是:" + e.getMessage());
		}
		return resMap;
	}

	/**
	 * @Title: 删除信息
	 * @Autowired
	 * @Description: 通过查找id删除信息
	 * @param albumid
	 * @return resMap
	 */
	@RequestMapping(value = "/delete")
	public String deletecolumn(HttpServletRequest request) {
		return "Album/delete";
	}

	
	/** 
	 * @Title: deleteAlbum 
	 * @Description: 删除相册
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deletecolumn")
	@ResponseBody
	public Map<String, Object> deleteAlbum(HttpServletRequest request) {
		String albumid = request.getParameter("albumnid");
		Map<String, Object> res = new HashMap<String, Object>();
		Map<String, Object> ret = new HashMap<String, Object>();
		try {
			albumService.deleteAlbum(albumid);
			ret.put("albumid", albumid);
			res.put(Params.RET_OBJ, ret);
		} catch (Exception e) {
			log.debug("删除相册抛出的异常信息是:" + e.getMessage());
		}

		return res;
	}

}