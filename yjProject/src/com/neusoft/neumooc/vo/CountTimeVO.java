package com.neusoft.neumooc.vo;

import com.neusoft.core.common.BaseVO;

/**
 * @ClassName: CountTimeVO
 * @Description: 统计模块结果类
 * @author Zhenglishen
 * @date 2016年7月27日
 */
public class CountTimeVO extends BaseVO {
	private String month;// 月份
	private String count;// 统计结果

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
