
/**   
 * @Title: AlbumServiceImpl.java 
 * @Package com.neusoft.neumooc.service 
 * @Description: TODO 
 * @author acer   
 * @date 2016年7月25日 下午1:42:31 
*/

package com.neusoft.neumooc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.core.common.exception.DAOException;
import com.neusoft.neumooc.dao.AlbumDao;
import com.neusoft.neumooc.vo.AlbumVo;


/** 
 * @ClassName: AlbumServiceImpl 
 * @Description: TODO 
 * @author Fuyongjun
 * @date 2016年7月25日
 */
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{
	@Autowired
	AlbumDao albumDao;
	/** 
	 * @Title: queryAlbumNum 
	 * @Description: TODO 
	 * @return
	 * @throws DAOException
	 */
	@Override
	public int queryAlbumNum() throws DAOException {
	
		return albumDao.queryAlbumNum();
	}
	/** 
	 * @Title: getAlbums 
	 * @Description: TODO 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws DAOException
	 */
	@Override
	public List<AlbumVo> getAlbums(int pageNo, int pageSize)
			throws DAOException {
		// TODO Auto-generated method stub
		return albumDao.getAlbums(pageNo, pageSize);
	}
	/** 
	 * @Title: addAlbum 
	 * @Description: TODO 
	 * @param albumName：专辑名字
	 * @param description：专辑描述
	 */
	@Override
	public void addAlbum(String albumName, String description) {
		// TODO Auto-generated method stub
		this.albumDao.addAlbum(albumName, description);
		
	}

	
	/** 
	 * @Title: getAlbum 
	 * @Description: TODO 1
	 * @param albumId:专辑id
	 * @return
	 */
	@Override
	public Map<String, Object> getAlbum(String albumId) {
		return albumDao.getAlbum(albumId);
	}

	
	/** 
	 * @Title: updateAlbum 
	 * @Description: TODO 
	 * @param map：相册信息
	 */
	

	/*public void updateAlbum(Map<String, Object> map) {
		this.albumDao.updateAlbum(map);
	}*/
	
	/** 
	 * @Title: deleteAlbum 
	 * @Description: TODO 
	 * @param albumId:专辑id
	 */
	
	@Override
	public void deleteAlbum(String albumid) {
		this.albumDao.deleteAlbum(albumid);
	}
	
	/** 
	 * @Title: updateAlbum 
	 * @Description: TODO 
	 * @param albumId
	 * @return
	 */
	
	@Override
	public Map<String, Object> updateAlbum(String albumid,String albumname,String description) {
		return albumDao.update(albumid,albumname,description);
	}
	
}
