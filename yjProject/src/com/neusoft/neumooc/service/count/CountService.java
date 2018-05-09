package com.neusoft.neumooc.service.count;

import java.util.List;
import java.util.Map;

import com.neusoft.core.common.exception.ServiceException;
import com.neusoft.neumooc.vo.CountYearVO;

/**
 * @ClassName: CountService
 * @Description: 统计业务逻辑处理类
 * @author Zhenglishen
 * @date 2016年7月28日
 */
public interface CountService {
	/**
	 * @Title: countPhotoNumber
	 * @Description: 照片统计
	 * @param countYearVO 前台传到后台的值
	 * @param List countPhoto 存储统计结果
	 * @return countPhoto 照片统计结果
	 * @throws ServiceException
	 */
	public List<Map<String, Object>> countPhotoNumber(CountYearVO countYearVO)
			throws ServiceException;
}
