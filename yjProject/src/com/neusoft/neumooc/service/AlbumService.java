
/**   
 * @Title: AlbumService.java 
 * @Package com.neusoft.neumooc.service 
 * @Description: TODO 
 * @author acer   
 * @date 2016年7月25日 下午1:42:15 
*/

package com.neusoft.neumooc.service;

import java.util.List;
import java.util.Map;

import com.neusoft.core.common.exception.DAOException;
import com.neusoft.neumooc.vo.AlbumVo;




/** 
 * @ClassName: AlbumService 
 * @Description: TODO 
 * @author acer
 * @date 2016年7月25日
 */
//专辑业务接口
public interface AlbumService 
{	  
	public int queryAlbumNum() throws DAOException; //查询总数
	public List<AlbumVo> getAlbums(int pageNo, int pageSize) throws DAOException;//分页
	public void addAlbum(String albumName,String description);//插入
	public Map<String,Object>getAlbum(String albumId);//通过id查询
	public Map<String,Object> updateAlbum(String albumid,String albumname,String description);//更新
	public void deleteAlbum(String albumId);//删除
	
	/** 
	 * @Title: getAlbum 
	 * @Description: TODO 
	 * @param albumId
	 * @return
	 */
	
	
}
