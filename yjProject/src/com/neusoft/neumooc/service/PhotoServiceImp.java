package com.neusoft.neumooc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.core.common.BaseService;
import com.neusoft.core.common.exception.DAOException;
import com.neusoft.core.common.exception.ServiceException;
import com.neusoft.neumooc.dao.PhotoDao;
import com.neusoft.neumooc.vo.AlbumVo;
import com.neusoft.neumooc.vo.PhotosVo;

/**
 * @ClassName: PhotoServiceImp
 * @Description: 图片列表业务逻辑处理类
 * @author HN
 * @date 2016年7月25日
 */
@Service
@Transactional
public class PhotoServiceImp extends BaseService implements PhotoService {
	@Autowired
	PhotoDao photodao;

	@Override
	public int getPhotosNumByAlbumId(String albumid) throws ServiceException {
		int PhotosNum = 0;
		try {
			PhotosNum = photodao.getPhotosNumByAlbumId(albumid);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return PhotosNum;
	}

	@Override
	public List<PhotosVo> getPhotosListByAlbumId(String albumid, int pageIndex,
			int pageSize) throws ServiceException {
		List<PhotosVo> PhotosList = null;
		try {

			PhotosList = photodao.getPhotosListByAlbumId(albumid, pageIndex,
					pageSize);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return PhotosList;

	}

	@Override
	public String getAlbumNameByAlbumId(String albumid) throws ServiceException {
		return photodao.getAlbumNameByAlbumId(albumid);
	}

	@Override
	public List<AlbumVo> getAlbumList() throws ServiceException {

		return photodao.getAlbumList();
	}

	@Override
	public Map<String, Object> getPhoto(String photoId) throws ServiceException {

		return photodao.getPhoto(photoId);
	}

	@Override
	public void addPhoto(PhotosVo photosvo) throws ServiceException {
		photodao.addPhoto(photosvo);

	}

	@Override
	public void updatePhoto(PhotosVo photovo) throws ServiceException {
		photodao.updatePhoto(photovo);

	}

	@Override
	public void deletePhoto(String photoid) throws ServiceException {
		photodao.deletePhoto(photoid);
	}

	@Override
	public void deletePhotos(String photoIds) throws ServiceException {
		photodao.deletePhotos(photoIds);
	}

	@Override
	public void updatePhotosAlbumId(String photoIds, String chooseAlbumname)
			throws ServiceException {
		this.photodao.updatePhotosAlbumId(photoIds, chooseAlbumname);

	}

	@Override
	public String getAlbumIdByAlbumName(String albumname)
			throws ServiceException {
		return this.photodao.getAlbumIdByAlbumName(albumname);
	}

}
