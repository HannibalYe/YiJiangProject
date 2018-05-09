package com.neusoft.neumooc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.core.common.BaseDAO;
import com.neusoft.core.common.exception.DAOException;
import com.neusoft.neumooc.vo.AlbumVo;
import com.neusoft.neumooc.vo.PhotosVo;

/**
 * @ClassName: PhotoDaoImp
 * @Description: 照片列表数据操作类
 * @author HN
 * @date 2016年7月25日
 */
@Repository
public class PhotoDaoImp extends BaseDAO implements PhotoDao {
	private final static String QUERY_AlbumNUM_SQL = "SELECT COUNT(1) FROM photo_photos where albumid=?";

	@Override
	public int getPhotosNumByAlbumId(String albumid) throws DAOException {
		Object[] args = { albumid };
		return this.queryInteger(QUERY_AlbumNUM_SQL, args);
	}

	private final static String QUERY_AlbumLIST_SQL = "SELECT photoid,photoname,albumid,description,phototype,DATE_FORMAT(screendate,'%Y-%m-%d') as screendate"
			+ " FROM photo_photos where albumid=?";

	@Override
	public List<PhotosVo> getPhotosListByAlbumId(String albumid, int pageIndex,
			int pageSize) throws DAOException {
		Object[] args = { albumid };
		return this.getPageData(QUERY_AlbumLIST_SQL, PhotosVo.class, pageIndex,
				pageSize, args);
	}

	private final static String GET_AlbumNameByAlbumId_SQL = "select albumname from photo_albums where albumid=?";

	@Override
	public String getAlbumNameByAlbumId(String albumid) throws DAOException {
		Object[] args = { albumid };
		return this.queryString(GET_AlbumNameByAlbumId_SQL, args);
	}

	private final static String QUERY_getAlbum_SQL = "SELECT * FROM photo_albums ";

	@Override
	public List<AlbumVo> getAlbumList() throws DAOException {
		return this.queryForBeanList(QUERY_getAlbum_SQL, AlbumVo.class);
	}

	private static final String SQL_queryone_Photos = "select photoid,photoname,albumid,description,phototype,DATE_FORMAT(screendate,'%Y-%m-%d') as screendate from photo_photos where photoid=?";

	@Transactional
	public Map<String, Object> getPhoto(String photoId) throws DAOException {
		Object[] args = { photoId };
		return this.queryForMap(SQL_queryone_Photos, args);
	}

	private static final String SQL_INSERT_Photos = "INSERT INTO photo_photos(photoid,photoname,albumid,description,phototype,screendate) values(:photoid,:photoname,:albumid,:description,:phototype,now())";

	@Transactional
	public void addPhoto(PhotosVo photolistvo) throws DAOException {
		this.update(SQL_INSERT_Photos, photolistvo);

	}

	private static final String SQL_update_Photo = "UPDATE photo_photos SET photoname=:photoname,description=:description,phototype=:phototype where photoid=:photoid";

	@Transactional
	public void updatePhoto(PhotosVo photolistvo) throws DAOException {
		this.update(SQL_update_Photo, photolistvo);
	}

	private final static String QUERY_deletePhoto_SQL = "delete from photo_photos where photoid=?";

	@Override
	public void deletePhoto(String photoid) throws DAOException {
		Object[] args = { photoid };
		this.update(QUERY_deletePhoto_SQL, args);
	}

	@Override
	public void deletePhotos(String photoIds) throws DAOException {
		String QUERY_deletePhotos_SQL = "delete from photo_photos where 1=1 ";
		String[] key_no_array = photoIds.split(",");
		QUERY_deletePhotos_SQL += "and photoid in(";
		for (int i = 0; i < key_no_array.length; i++) {
			QUERY_deletePhotos_SQL += "'" + key_no_array[i] + "'";
			if (key_no_array.length - 1 != i) {
				QUERY_deletePhotos_SQL += ",";
			}
		}
		QUERY_deletePhotos_SQL += ")";
		this.update(QUERY_deletePhotos_SQL);
	}

	@Override
	public void updatePhotosAlbumId(String photoIds, String albumid)
			throws DAOException {
		String QUERY_MovePhoto_SQL = "update photo_photos set albumid=";
		String[] key_no_array = photoIds.split(",");
		QUERY_MovePhoto_SQL += "'" + albumid + "'";
		QUERY_MovePhoto_SQL += " where photoid in(";
		for (int i = 0; i < key_no_array.length; i++) {
			QUERY_MovePhoto_SQL += "'" + key_no_array[i] + "'";
			if (key_no_array.length - 1 != i) {
				QUERY_MovePhoto_SQL += ",";
			}
		}
		QUERY_MovePhoto_SQL += ")";
		this.update(QUERY_MovePhoto_SQL);
	}

	private final static String GET_AlbumIdByAlbumName_SQL = "select albumid from photo_albums where albumname=?";

	@Override
	public String getAlbumIdByAlbumName(String albumname) throws DAOException {
		Object[] args = { albumname };
		return this.queryString(GET_AlbumIdByAlbumName_SQL, args);
	}
}
