package com.neusoft.neumooc.dao.search;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neusoft.core.common.BaseDAO;
import com.neusoft.core.common.exception.DAOException;
import com.neusoft.neumooc.vo.HomepageSearchVO;
import com.neusoft.neumooc.vo.PhotosVo;

/**
 * @ClassName: homepageSearchDAOImpI
 * @Description: 主页搜索数据操作类
 * @author zhenglishen
 * @date 2016年7月26日
 */
@Repository
public class HomepageSearchDAOImpI extends BaseDAO implements HomepageSearchDAO {
	@Override
	public List<PhotosVo> getSearchPhotosList(
			HomepageSearchVO homepageSearchVO,
			List<Map<String, Object>> albumid, int pageIndex, int pageSize)
			throws DAOException {
		String SEARCH_RESULTList_SQL = "select photo_photos.photoid,photo_photos.photoname,photo_photos.albumid,photo_photos.screendate,photo_photos.description,photo_photos.phototype from photo_photos left join photo_albums on photo_photos.albumid=photo_albums.albumid where 1=1";
		if (homepageSearchVO.getSearchphotoname() != null
				&& homepageSearchVO.getSearchphotoname() != "") {
			SEARCH_RESULTList_SQL += " and photo_photos.photoname like '%"
					+ homepageSearchVO.getSearchphotoname() + "%'";
		}
		if (albumid.size() != 0) {
			for (Map<String, Object> map : albumid) {
				for (Map.Entry<String, Object> e : map.entrySet()) {
					SEARCH_RESULTList_SQL += " and photo_photos.albumid = '"
							+ e.getValue() + "'";
				}
			}
		}
		if (homepageSearchVO.getSearchscreendate() != null
				&& homepageSearchVO.getSearchscreendate() != "") {
			SEARCH_RESULTList_SQL += " and photo_photos.screendate like '%"
					+ homepageSearchVO.getSearchscreendate() + "%'";
		}
		if (homepageSearchVO.getSearchdescription() != null
				&& homepageSearchVO.getSearchdescription() != "") {
			SEARCH_RESULTList_SQL += " and photo_photos.description like '%"
					+ homepageSearchVO.getSearchdescription() + "%'";
		}

		return this.getPageData(SEARCH_RESULTList_SQL, PhotosVo.class,
				pageIndex, pageSize);
	}

	@Override
	public int getSearchPhotosNum(HomepageSearchVO homepageSearchVO,
			List<Map<String, Object>> albumid) throws DAOException {
		String SEARCH_RESULTNum_SQL = "select count(1) from photo_photos left join photo_albums on photo_photos.albumid=photo_albums.albumid where 1=1";
		if (homepageSearchVO.getSearchphotoname() != null
				&& homepageSearchVO.getSearchphotoname() != "") {
			SEARCH_RESULTNum_SQL += " and photo_photos.photoname like '%"
					+ homepageSearchVO.getSearchphotoname() + "%'";
		}
		if (albumid.size() != 0) {
			for (Map<String, Object> map : albumid) {
				for (Map.Entry<String, Object> e : map.entrySet()) {
					SEARCH_RESULTNum_SQL += " and photo_photos.albumid = '"
							+ e.getValue() + "'";
				}
			}
		}
		if (homepageSearchVO.getSearchscreendate() != null
				&& homepageSearchVO.getSearchscreendate() != "") {
			SEARCH_RESULTNum_SQL += " and photo_photos.screendate like '%"
					+ homepageSearchVO.getSearchscreendate() + "%'";
		}
		if (homepageSearchVO.getSearchdescription() != null
				&& homepageSearchVO.getSearchdescription() != "") {
			SEARCH_RESULTNum_SQL += " and photo_photos.description like '%"
					+ homepageSearchVO.getSearchdescription() + "%'";
		}
		return this.queryForInteger(SEARCH_RESULTNum_SQL);
	}

	@Override
	public List<Map<String, Object>> getAlbumIdBySearchName(String searchname)
			throws DAOException {
		String SEARCH_getAlbumIdBySearchName_SQL = "select albumid from photo_albums where 1=1";
		SEARCH_getAlbumIdBySearchName_SQL += " and albumname like '%"
				+ searchname + "%'";
		return this.queryForList(SEARCH_getAlbumIdBySearchName_SQL);
	}
}
