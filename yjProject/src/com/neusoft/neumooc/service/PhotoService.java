package com.neusoft.neumooc.service;

import java.util.List;
import java.util.Map;

import com.neusoft.core.common.exception.ServiceException;
import com.neusoft.neumooc.vo.AlbumVo;
import com.neusoft.neumooc.vo.PhotosVo;

/**
 * @ClassName: PhotoService
 * @Description: 图片列表业务逻辑处理类
 * @author HN
 * @date 2016年7月25日
 */
public interface PhotoService {

	/**
	 * @Title: getPhotosNumByAlbumId
	 * @Description: 查询某个相册的总数量
	 * @param albumid
	 *            相册编号
	 * @return
	 * @throws ServiceException
	 */
	public int getPhotosNumByAlbumId(String albumid) throws ServiceException;

	/**
	 * @Title: getPhotosListByAlbumId
	 * @Description: 查询某个相册的照片列表
	 * @param albumid
	 *            相册编号
	 * @param pageIndex
	 *            上一页的总个数
	 * @param pageSize
	 *            每页数量
	 * @return
	 * @throws ServiceException
	 */
	public List<PhotosVo> getPhotosListByAlbumId(String albumid, int pageIndex,
			int pageSize) throws ServiceException;

	/**
	 * @Title: getAlbumList
	 * @Description: 获得其他相册
	 * @param albumId
	 *            相册编号
	 * @return
	 * @throws ServiceException
	 */
	public List<AlbumVo> getAlbumList() throws ServiceException;

	/**
	 * @Title: getAlbumNameByAlbumId
	 * @Description: 获取照片名称
	 * @param albumid
	 *            相册编号
	 * @return
	 * @throws ServiceException
	 */
	public String getAlbumNameByAlbumId(String albumid) throws ServiceException;

	/**
	 * @Title: getPhoto
	 * @Description: 获取照片信息
	 * @param photoId
	 *            照片编号
	 * @return
	 * @throws ServiceException
	 */
	public Map<String, Object> getPhoto(String photoId) throws ServiceException;

	/**
	 * @Title: addPhoto
	 * @Description: 添加新照片
	 * @param photolistvo
	 *            照片信息
	 * @param contentId
	 *            照片编号
	 * @param type
	 *            照片类型
	 * @throws ServiceException
	 */
	public void addPhoto(PhotosVo photolistvo) throws ServiceException;

	/**
	 * @Title: updatePhoto
	 * @Description: 更新照片信息
	 * @param photolistvo
	 *            照片信息
	 * @throws ServiceException
	 */
	public void updatePhoto(PhotosVo photolistvo) throws ServiceException;

	/**
	 * @Title: deletePhoto
	 * @Description: 删除照片
	 * @param photoId
	 *            照片编号
	 * @throws ServiceException
	 */
	public void deletePhoto(String photoId) throws ServiceException;

	/**
	 * @Title: deletePhotos
	 * @Description: 批量删除照片
	 * @param photoIds
	 *            照片编号数组
	 * @throws ServiceException
	 */
	public void deletePhotos(String photoIds) throws ServiceException;

	/**
	 * @Title: updatePhotosAlbumId
	 * @Description: 将照片移到相册
	 * @param photoIds
	 *            照片编号(数组)
	 * @param albumId
	 *            相册编号
	 * @throws ServiceException
	 */
	public void updatePhotosAlbumId(String photoIds, String albumid)
			throws ServiceException;

	/**
	 * @Title: getAlbumIdByAlbumName
	 * @Description: 根据相册名称查找相册编号
	 * @param albumname
	 *            相册名称
	 * @return
	 * @throws ServiceException
	 */
	public String getAlbumIdByAlbumName(String albumname)
			throws ServiceException;
}
