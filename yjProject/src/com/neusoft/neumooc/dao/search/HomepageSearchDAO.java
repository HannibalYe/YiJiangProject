package com.neusoft.neumooc.dao.search;

import java.util.List;
import java.util.Map;

import com.neusoft.core.common.exception.DAOException;
import com.neusoft.neumooc.vo.HomepageSearchVO;
import com.neusoft.neumooc.vo.PhotosVo;

/**
 * @ClassName: homepageSearchDAO
 * @Description: 主页搜索数据操作类
 * @author Zhenglishen
 * @date 2016年7月26日
 */
public interface HomepageSearchDAO {
	/**
	 * @Title: homepageResult
	 * @Description: 查询主页搜索条件
	 * @param homepageSearchVO
	 * @return SEARCH_RESULTList_SQL sql语句查询结果PhotosVo.class,
				pageIndex, pageSize
	 * @throws DAOException
	 */
	public List<PhotosVo> getSearchPhotosList(
			HomepageSearchVO homepageSearchVO,
			List<Map<String, Object>> albumid, int pageIndex, int pageSize)
			throws DAOException;

	/**
	 * @Title: getSearchPhotosNum
	 * @Description: 搜索后的数量
	 * @param homepageSearchVO
	 * @return SEARCH_RESULTNum_SQL
	 * @throws DAOException
	 */
	public int getSearchPhotosNum(HomepageSearchVO homepageSearchVO,
			List<Map<String, Object>> albumid) throws DAOException;

	/**
	 * @Title: getAlbumIdBySearchName
	 * @Description: 根据搜索相册名找其编号
	 * @param searchname 搜索相册名
	 * @return SEARCH_getAlbumIdBySearchName_SQL sql搜索结果
	 * @throws DAOException
	 */
	public List<Map<String, Object>> getAlbumIdBySearchName(String searchname)
			throws DAOException;
}
