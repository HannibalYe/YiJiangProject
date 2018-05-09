
/**   
 * @Title: AlbumDao.java 
 * @Package com.neusoft.neumooc.dao 
 * @Description: TODO 
 * @author acer   
 * @date 2016年7月25日 下午1:41:16 
*/
package com.neusoft.neumooc.dao;
import java.util.List;
import java.util.Map;

import com.neusoft.core.common.exception.DAOException;
import com.neusoft.neumooc.vo.AlbumVo;
/** 
 * @ClassName: AlbumDao 
 * @Description: TODO 
 * @author fuyongjun
 * @date 2016年7月25日
 */
/*专辑增删改查Dao层*/
public interface AlbumDao {
     
	public int queryAlbumNum() throws DAOException; //查询总数
	public List<AlbumVo> getAlbums(int pageNo, int pageSize) throws DAOException;//分页
	public void addAlbum(String albumName,String description);//插入
	public Map<String,Object>getAlbum(String albumId);//通过id查询
	public Map<String,Object>update(String albumid,String albumname,String description );//通过id更新
    public void deleteAlbum(String albumId);//删除
}
