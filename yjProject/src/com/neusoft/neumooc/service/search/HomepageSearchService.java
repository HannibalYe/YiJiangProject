package com.neusoft.neumooc.service.search;

import java.util.List;
import java.util.Map;

import com.neusoft.core.common.exception.ServiceException;
import com.neusoft.neumooc.vo.HomepageSearchVO;
import com.neusoft.neumooc.vo.PhotosVo;

/**
 * @ClassName: HomepageSearchService
 * @Description: TODO
 * @author Zhenglishen
 * @date 2016年7月29日
 */
public interface HomepageSearchService {
	/**
	 * @Title: getSearchPhotosList
	 * @Description: 查询照片结果列表
	 * @param homepageSearchVO
	 * @param albumid 相册编号
	 * @param pageIndex
	 * @param pageSize
	 * @return SearchPhotosList
	 * @throws ServiceException
	 */
	public List<PhotosVo> getSearchPhotosList(
			HomepageSearchVO homepageSearchVO,
			List<Map<String, Object>> albumid, int pageIndex, int pageSize)
			throws ServiceException;

	/**
	 * @Title: getSearchPhotosNum
	 * @Description: TODO
	 * @param homepageSearchVO
	 * @param albumid
	 * @return SearchPhotosNum 搜索后的数量
	 * @throws ServiceException
	 */
	public int getSearchPhotosNum(HomepageSearchVO homepageSearchVO,
			List<Map<String, Object>> albumid) throws ServiceException;

	/**
	 * @Title: getAlbumIdBySearchName
	 * @Description: 根据搜索名称查询相册编号
	 * @param searchname
	 *            搜索名称
	 * @return searchname sql搜索结果
	 * @throws ServiceException
	 */
	public List<Map<String, Object>> getAlbumIdBySearchName(String searchname)
			throws ServiceException;
}
