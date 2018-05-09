package com.neusoft.neumooc.service.count;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.core.common.BaseService;
import com.neusoft.core.common.exception.DAOException;
import com.neusoft.core.common.exception.ServiceException;
import com.neusoft.neumooc.dao.count.CountPhotoDAO;
import com.neusoft.neumooc.vo.CountYearVO;

/** 
 * @ClassName: CountServiceImpI 
 * @Description: 统计业务逻辑处理类
 * @author Zhenglishen
 * @date 2016年7月29日
 */
@Service
@Transactional
public class CountServiceImpI extends BaseService implements CountService {
	@Autowired
	private CountPhotoDAO CountPhotoDAO;
	@Override
	public List<Map<String, Object>> countPhotoNumber(CountYearVO countYearVO)
			throws ServiceException {
		List<Map<String, Object>> countPhoto = null;
		try {
			countPhoto = CountPhotoDAO.countPhotodate(countYearVO);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return countPhoto;
	}
}
