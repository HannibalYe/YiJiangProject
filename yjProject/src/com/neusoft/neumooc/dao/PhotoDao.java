package com.neusoft.neumooc.dao;

import java.util.List;
import java.util.Map;

import com.neusoft.core.common.exception.DAOException;
import com.neusoft.core.common.exception.ServiceException;
import com.neusoft.neumooc.vo.AlbumVo;
import com.neusoft.neumooc.vo.PhotosVo;

/**
 * @ClassName: PhotoDao
 * @Description: 图片列表数据操作类
 * @author HN
 * @date 2016年7月25日
 */
public interface PhotoDao {

	/**
	 * @Title: getPhotosNumByAlbumId
	 * @Description: 查询某个相册的总数量
	 * @param albumid
	 *            相册编号
	 * @return
	 * @throws DAOException
	 */
	public int getPhotosNumByAlbumId(String albumid) throws DAOException;

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
	 * @throws DAOException
	 */
	public List<PhotosVo> getPhotosListByAlbumId(String albumid, int pageIndex,
			int pageSize) throws DAOException;

	/**
	 * @Title: getAlbumNameByAlbumId
	 * @Description: 根据相册编号查找相册名称
	 * @param albumid
	 *            相册编号
	 * @return
	 * @throws DAOException
	 */

	public String getAlbumNameByAlbumId(String albumid) throws DAOException;

	/**
	 * @Title: getAlbumIdByAlbumName
	 * @Description: 根据相册名称查找相册编号
	 * @param albumname
	 *            相册名称
	 * @return
	 * @throws ServiceException
	 */
	public String getAlbumIdByAlbumName(String albumname) throws DAOException;

	/**
	 * @Title: getAlbumList
	 * @Description: 获得其他相册
	 * @param albumId
	 *            相册编号
	 * @return
	 * @throws DAOException
	 */
	public List<AlbumVo> getAlbumList() throws DAOException;

	/**
	 * @Title: getPhoto
	 * @Description: 获取照片信息
	 * @param photoId
	 *            照片编号
	 * @return
	 * @throws DAOException
	 */
	public Map<String, Object> getPhoto(String photoId) throws DAOException;

	/**
	 * @Title: addPhoto
	 * @Description: 添加新照片
	 * @param photolistvo
	 *            照片信息
	 * @param contentId
	 *            照片编号
	 * @param type
	 *            照片类型
	 * @throws DAOException
	 */
	public void addPhoto(PhotosVo photosvo) throws DAOException;

	/**
	 * @Title: updatePhoto
	 * @Description: 更新照片信息
	 * @param photolistvo
	 *            照片信息
	 * @throws DAOException
	 */
	public void updatePhoto(PhotosVo photosvo) throws DAOException;

	/**
	 * @Title: deletePhoto
	 * @Description: 删除照片
	 * @param photoId
	 *            照片编号
	 * @throws DAOException
	 */
	public void deletePhoto(String photoId) throws DAOException;

	/**
	 * @Title: deletePhotos
	 * @Description: 批量删除照片
	 * @param photoIds
	 *            照片编号数组
	 * @throws DAOException
	 */
	public void deletePhotos(String photoIds) throws DAOException;

	/**
	 * @Title: updatePhotosAlbumId
	 * @Description: 将照片移动到相册
	 * @param photoIds
	 *            照片数组
	 * @param albumId
	 *            相册编号
	 * @throws DAOException
	 */
	public void updatePhotosAlbumId(String photoIds, String albumId)
			throws DAOException;
}
