package com.neusoft.neumooc.dao.count;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neusoft.core.common.BaseDAO;
import com.neusoft.core.common.exception.DAOException;
import com.neusoft.neumooc.vo.CountYearVO;


/** 
 * @ClassName: CountPhotoDAOImpI 
 * @Description: 统计照片个数数据操作类
 * @author zhenglishen
 * @date 2016年7月29日
 */
@Repository
public class CountPhotoDAOImpI extends BaseDAO implements CountPhotoDAO {

	@Override
	public List<Map<String, Object>> countPhotodate(CountYearVO countYearVO)
			throws DAOException {
		String year = countYearVO.getYear();
		String COUNTPHOTODATE_SQL = "SELECT DATE_FORMAT(screendate,'%m')AS month,"
				+ " count(1) count FROM photo_photos"
				+ " WHERE YEAR(screendate) = "
				+ year
				+ " GROUP BY DATE_FORMAT(screendate,'%m')";
		return this.queryForList(COUNTPHOTODATE_SQL);
	}

}
