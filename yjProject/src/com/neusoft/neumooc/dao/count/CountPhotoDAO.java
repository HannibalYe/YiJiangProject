package com.neusoft.neumooc.dao.count;

import java.util.List;
import java.util.Map;

import com.neusoft.core.common.exception.DAOException;
import com.neusoft.neumooc.vo.CountYearVO;

/**
 * @ClassName: CountPhotoDAO
 * @Description: 统计照片个数数据操作类
 * @author zhenglishen
 * @date 2016年7月29日
 */
public interface CountPhotoDAO {
	/**
	 * @Title: countPhotodate
	 * @Description: 统计照片个数
	 * @param countYearVO
	 * @return COUNTPHOTODATE_SQL SQL统计结果
	 * @throws DAOException
	 */
	public List<Map<String, Object>> countPhotodate(CountYearVO countYearVO)
			throws DAOException;
}
