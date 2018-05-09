package com.neusoft.neumooc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.neusoft.core.common.BaseController;
import com.neusoft.core.common.conf.Params;
import com.neusoft.core.common.exception.ServiceException;
import com.neusoft.core.common.pagination.Paginating;
import com.neusoft.core.util.FileUtils;
import com.neusoft.core.util.IDUtil;
import com.neusoft.neumooc.service.PhotoService;
import com.neusoft.neumooc.service.count.CountService;
import com.neusoft.neumooc.service.search.HomepageSearchService;
import com.neusoft.neumooc.vo.CountYearVO;
import com.neusoft.neumooc.vo.HomepageSearchVO;
import com.neusoft.neumooc.vo.PhotosVo;

/**
 * @ClassName: PhotolistController
 * @Description: 图片列表,搜索,统计
 * @author HN Zhenglishen
 * @date 2016年7月25日
 */

@Controller
@RequestMapping(value = "/photo")
public class PhotoController extends BaseController {
	@Autowired
	PhotoService photoservice;
	@Autowired
	HomepageSearchService homepageSearchService;
	@Autowired
	CountService countService;
	/** 
	 * @Title: viewPhoto 
	 * @Description: 显示相片
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/viewPhoto")
	public String viewPhoto(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String photoid = request.getParameter("photoid");
		Map<String, Object> photoInfo = photoservice.getPhoto(photoid);
		model.addAttribute("photoInfo", photoInfo);
		return "home/index";
	}
	/** 
	 * @Title: add 
	 * @Description: 添加新相片
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Map<String, Object> add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String photoid = IDUtil.getID();
		String photoName = request.getParameter("photoName");
		String photoDescribe = request.getParameter("photoDescribe");
		String chooseAlbumname = request.getParameter("chooseAlbumname");
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			String albumid = photoservice.getAlbumIdByAlbumName(chooseAlbumname);
			Boolean flag = false;
			// 上传图片
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
			if (multipartResolver.isMultipart(request)) {
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				Iterator<String> iter = multipartRequest.getFileNames();
				while (iter.hasNext()) {
					MultipartFile file = multipartRequest.getFile((String) iter
							.next());
					// 判断上传文件类型是否允许上传
					if (FileUtils.isImageFile(file)) {
						String pic_path = request.getSession().getServletContext()
								.getRealPath("/resources/upload/uploadimg");
						String originalFilename = file.getOriginalFilename();
						String newfileName = UUID.randomUUID()
								+ originalFilename.substring(originalFilename
										.lastIndexOf("."));
						File localfile = new File(pic_path + "\\/" + newfileName);
						try {
							file.transferTo(localfile);
						} catch (IllegalStateException | IOException e) {
							e.printStackTrace();
						}
						flag = true;
						PhotosVo photosvo = new PhotosVo();
						photosvo.setPhotoid(photoid);
						photosvo.setPhotoname(photoName);
						photosvo.setAlbumid(albumid);
						photosvo.setDescription(photoDescribe);
						photosvo.setPhototype(newfileName);
						photoservice.addPhoto(photosvo);
					}
				}
			}
			if (flag == false) {
				String newfileName = "photo1.jpg";
				PhotosVo photosvo = new PhotosVo();
				photosvo.setPhotoid(photoid);
				photosvo.setPhotoname(photoName);
				photosvo.setAlbumid(albumid);
				photosvo.setDescription(photoDescribe);
				photosvo.setPhototype(newfileName);
				photoservice.addPhoto(photosvo);
			}
			resMap.put(Params.RET_CODE, "success");
			resMap.put(Params.RET_OBJ, retMap);
		} catch (Exception e) {
			log.debug("有异常信息抛出:" + e.getMessage());
		}
		return resMap;
	}

	/** 
	 * @Title: edit 
	 * @Description: 准备修改相片图片
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request)
			throws Exception {
		String photoid = request.getParameter("photoid");
		Map<String, Object> photoInfo = photoservice.getPhoto(photoid);
		model.addAttribute("photoInfo", photoInfo);
		return "home/editPhoto";
	}
	/** 
	 * @Title: update 
	 * @Description: 更新相片信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public Map<String, Object> update(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String photoid = request.getParameter("photoid");
		String photoname = request.getParameter("photoName");
		String description = request.getParameter("photoDescribe");
		String phototype = request.getParameter("phototype");
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> retMap = new HashMap<String, Object>();
		Boolean flag = false;
		try {
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
			if (multipartResolver.isMultipart(request)) {
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				Iterator<String> iter = multipartRequest.getFileNames();
				while (iter.hasNext()) {
					MultipartFile file = multipartRequest.getFile((String) iter
							.next());
					// 判断上传文件类型是否允许上传
					if (FileUtils.isImageFile(file)) {
						String pic_path = request.getSession().getServletContext()
								.getRealPath("/resources/upload/uploadimg");
						String originalFilename = file.getOriginalFilename();
						String newfileName = UUID.randomUUID()
								+ originalFilename.substring(originalFilename
										.lastIndexOf("."));
						File localfile = new File(pic_path + "\\/" + newfileName);
						try {
							file.transferTo(localfile);
						} catch (IllegalStateException | IOException e) {
							e.printStackTrace();
						}
						flag = true;
						PhotosVo photovo = new PhotosVo();
						photovo.setPhotoname(photoname);
						photovo.setDescription(description);
						photovo.setPhotoid(photoid);
						photovo.setPhototype(newfileName);
						photoservice.updatePhoto(photovo);
					}
				}
			}
			if (flag == false) {
				PhotosVo photovo = new PhotosVo();
				photovo.setPhotoname(photoname);
				photovo.setDescription(description);
				photovo.setPhotoid(photoid);
				photovo.setPhototype(phototype);
				photoservice.updatePhoto(photovo);
			}
			resMap.put(Params.RET_CODE, "success");
			resMap.put(Params.RET_OBJ, retMap);
		} catch (Exception e) {
			log.debug("有异常信息抛出:" + e.getMessage());
		}
		return resMap;
	}
	/** 
	 * @Title: delete 
	 * @Description: 删除相片
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request)
			throws Exception {
		String photoid = request.getParameter("photoid");
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			photoservice.deletePhoto(photoid);
			resMap.put(Params.RET_CODE, "success");
			resMap.put(Params.RET_OBJ, retMap);
		} catch (Exception e) {
			log.debug("有异常信息抛出:" + e.getMessage());
		}
		return resMap;
	}
	/** 
	 * @Title: deletes 
	 * @Description: 批量删除相片
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deletes")
	@ResponseBody
	public Map<String, Object> deletes(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> retMap = new HashMap<String, Object>();
		String assignIds = request.getParameter("photoids");
		try {
			photoservice.deletePhotos(assignIds);
			resMap.put(Params.RET_CODE, "success");
			resMap.put(Params.RET_OBJ, retMap);
		} catch (Exception e) {
			log.debug("有异常信息抛出:" + e.getMessage());
		}
		return resMap;
	}
	/** 
	 * @Title: change 
	 * @Description: 改变相片的相册
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/change")
	@ResponseBody
	public Map<String, Object> change(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String chooseAlbumname = request.getParameter("chooseAlbumname");
		String photoids = request.getParameter("photoids");
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			String albumid = photoservice.getAlbumIdByAlbumName(chooseAlbumname);
			photoservice.updatePhotosAlbumId(photoids, albumid);
			resMap.put(Params.RET_CODE, "success");
			resMap.put(Params.RET_OBJ, retMap);
		} catch (Exception e) {
			log.debug("有异常信息抛出:" + e.getMessage());
		}
		return resMap;
	}
	/** 
	 * @Title: widgets 
	 * @Description: 搜索功能+分页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/widgets")
	@ResponseBody
	public Map<String, Object> widgets(HttpServletRequest request,
			HttpServletResponse response) {
		String photoname = request.getParameter("photoName");
		String albumname = request.getParameter("albumName");
		String screendate = request.getParameter("time");
		String description = request.getParameter("photoDescribe");
		Map<String, String> params = new HashMap<String, String>();
		// 分页参数
		Paginating page = getPaginating(request);
		this.loadPagination(params, page);
		HomepageSearchVO homepagesearchvo = new HomepageSearchVO();
		homepagesearchvo.setSearchphotoname(photoname);
		homepagesearchvo.setSearchdescription(description);
		homepagesearchvo.setSearchscreendate(screendate);
		Map<String, Object> resMap = new HashMap<String, Object>();
		try {
			if (albumname != null && albumname != "") {
				List<Map<String, Object>> albumid = homepageSearchService
						.getAlbumIdBySearchName(albumname);
				List<PhotosVo> photoList = homepageSearchService
						.getSearchPhotosList(homepagesearchvo, albumid,
								page.getPageIndex(), page.getPageSize());
				resMap = new HashMap<String, Object>();
				int photoSearchNum = homepageSearchService.getSearchPhotosNum(
						homepagesearchvo, albumid);
				resMap.put("rows", photoList);
				resMap.put("total", photoSearchNum);	
			} else {
				List<Map<String, Object>> albumid = new ArrayList<Map<String, Object>>();
				List<PhotosVo> photoList = homepageSearchService
						.getSearchPhotosList(homepagesearchvo, albumid,
								page.getPageIndex(), page.getPageSize());
				resMap = new HashMap<String, Object>();
				int photoSearchNum = homepageSearchService.getSearchPhotosNum(
						homepagesearchvo, albumid);
				resMap.put("rows", photoList);
				resMap.put("total", photoSearchNum);
			}
		} catch (ServiceException e) {
			log.debug("有异常信息抛出:" + e.getMessage());
		}
		return resMap;
	}

	/** 
	 * @Title: counter 
	 * @Description: 统计功能
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/counter")
	@ResponseBody
	public Map<String, Object> counter(HttpServletRequest request,
			HttpServletResponse response) {
		CountYearVO countYearVO = new CountYearVO();
		countYearVO.setYear(request.getParameter("selectedYear"));
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> countPhotoNumber = countService
					.countPhotoNumber(countYearVO);
			List<Object> dataList = new ArrayList<Object>();
			// 判断取出的数据是否为空
			if (countPhotoNumber.size() == 0) {
				for (int i = 1; i < 13; i++) {
					Map<String, Object> noadd = new HashMap<String, Object>();
					noadd.put("month", String.valueOf(i));
					noadd.put("count", "0");
					dataList.add(noadd);
				}
			} else {
				// 循环算法(封装),将月份和空值补齐
				for (int i = 1; i < 13; i++) {
					Map<String, Object> monthMap = new HashMap<String, Object>();
					for (int j = 0; j < countPhotoNumber.size(); j++) {
						Map<String, Object> objectMap = (Map<String, Object>) countPhotoNumber
								.get(j);
						int k = 0;
						String l;
						if (i < 10) {
							l = String.valueOf(k) + String.valueOf(i);
						} else {
							l = String.valueOf(i);
						}
						if (objectMap.get("month").equals(String.valueOf(l))) {
							monthMap.put("month", objectMap.get("month"));
							monthMap.put("count", objectMap.get("count"));
							break;
						} else {
							if (j == countPhotoNumber.size() - 1) {
								monthMap.put("month", i);
								monthMap.put("count", "0");
							}
						}
					}
					dataList.add(monthMap);
				}
			}
			retMap.put("dataList", dataList);
		} catch (ServiceException e) {
			log.debug("有异常信息抛出:" + e.getMessage());
		}
		return retMap;
	}
}
