package com.neusoft.neumooc.service.search;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.core.common.BaseService;
import com.neusoft.core.common.exception.DAOException;
import com.neusoft.core.common.exception.ServiceException;
import com.neusoft.neumooc.dao.search.HomepageSearchDAO;
import com.neusoft.neumooc.vo.HomepageSearchVO;
import com.neusoft.neumooc.vo.PhotosVo;

/**
 * @ClassName: HomepageSearchServiceImpI
 * @Description: 搜索业务逻辑处理类
 * @author Zhenglishen
 * @date 2016年7月28日
 */

@Service
@Transactional
public class HomepageSearchServiceImpI extends BaseService implements
		HomepageSearchService {
	@Autowired
	private HomepageSearchDAO homepageSearchDAO;

	@Override
	public List<PhotosVo> getSearchPhotosList(
			HomepageSearchVO homepageSearchVO,
			List<Map<String, Object>> albumid, int pageIndex, int pageSize)
			throws ServiceException {
		List<PhotosVo> SearchPhotosList = null;
		try {

			SearchPhotosList = homepageSearchDAO.getSearchPhotosList(
					homepageSearchVO, albumid, pageIndex, pageSize);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return SearchPhotosList;
	}

	@Override
	public int getSearchPhotosNum(HomepageSearchVO homepageSearchVO,
			List<Map<String, Object>> albumid) throws ServiceException {
		int SearchPhotosNum = 0;
		try {
			SearchPhotosNum = homepageSearchDAO.getSearchPhotosNum(
					homepageSearchVO, albumid);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return SearchPhotosNum;

	}

	@Override
	public List<Map<String, Object>> getAlbumIdBySearchName(String searchname)
			throws ServiceException {
		return homepageSearchDAO.getAlbumIdBySearchName(searchname);
	}

}
