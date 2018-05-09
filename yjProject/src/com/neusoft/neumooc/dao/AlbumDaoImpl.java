/**   
 * @Title: AlbumDaoImpl.java 
 * @Package com.neusoft.neumooc.dao 
 * @Description: TODO 
 * @author acer   
 * @date 2016年7月25日 下午1:41:58 
 */
package com.neusoft.neumooc.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.neusoft.core.common.BaseDAO;
import com.neusoft.core.common.exception.DAOException;
import com.neusoft.core.util.IDUtil;
import com.neusoft.neumooc.vo.AlbumVo;
/**
 * @ClassName: AlbumDaoImpl
 * @Description: TODO
 * @author fuyongjun
 * @date 2016年7月25日
 */
@Repository
public class AlbumDaoImpl extends BaseDAO implements AlbumDao {
	private final static String QUERR_AlbumNum_SQL = "SELECT COUNT(*)FROM photo_albums";
	private final static String QUERR_Album_SQL = "SELECT * FROM photo_albums";
	private final static String QUERR_Add_Album_SQL = "INSERT INTO photo_albums(albumid,albumname,description,builddate)VALUES(?,?,?,now())";
	private final static String QUERR_DELETE_Album_SQL = "DELETE  FROM photo_albums WHERE albumid=?";
	private final static String QUERR_ID_SQL = "SELECT *FROM photo_albums WHERE albumid=?";
	private final static String QUERR_UPDATE_SQL = "UPDATE photo_albums SET albumname=?,description=? WHERE albumid=?";

	/**
	 * @Title: queryAlbumNum
	 * @Description: TODO
	 * @return int
	 * @throws DAOException
	 */
	/* 获得列表个数 */
	@Override
	public int queryAlbumNum() throws DAOException {

		return this.queryForInteger(QUERR_AlbumNum_SQL); // 查询个数
	}

	/**
	 * @Title: getAlbums
	 * @Description: TODO
	 * @param pageNo
	 *            ：页数
	 * @param pageSize
	 *            ：页显示数量
	 * @return List<AlbumVo>
	 * @throws DAOException
	 */
	// 获取列表
	@Override
	public List<AlbumVo> getAlbums(int pageNo, int pageSize)
			throws DAOException {
		return this.getPageData(QUERR_Album_SQL, AlbumVo.class, pageNo,
				pageSize);
	}

	/**
	 * @Title: addAlbum
	 * @Description: TODO
	 * @param albumName
	 *            :专辑名字
	 * @param description
	 *            ：专辑描述
	 */
	/* 创建专辑 */
	@Override
	public void addAlbum(String albumname, String description) {
		String planid = IDUtil.getID();
		this.update(QUERR_Add_Album_SQL, new Object[] {planid, albumname,
				description });
	}

	/**
	 * @Title: getAlbum
	 * @Description: TODO
	 * @param albumId
	 *            ：专辑id
	 * @return Map<String,Object>
	 */
	/* 通过id查询列表 */
	@Override
	public Map<String, Object> getAlbum(String albumId) {
		return this.queryForMap(QUERR_ID_SQL, new Object[] { albumId });
	}

	/**
	 * @Title: updateAlbum
	 * @Description: TODO
	 * @param map
	 *            ：相册信息
	 */
	/* 更新列表 */
	@Override
	public Map<String, Object> update(String albumid, String albumname,
			String description) throws DAOException {
		Map<String, Object> up = new HashMap<String, Object>();
		int updates = this.update(QUERR_UPDATE_SQL, new Object[] { albumname,
				description, albumid });
		up.put("success", updates);
		return up;
	}

	/**
	 * @Title: deleteAlbum
	 * @Description: TODO
	 * @param albumId
	 *            :专辑id
	 */
	/* 通过id删除属性 */
	@Override
	public void deleteAlbum(String albumid) {
		this.update(QUERR_DELETE_Album_SQL, new Object[] { albumid });
	}
}
