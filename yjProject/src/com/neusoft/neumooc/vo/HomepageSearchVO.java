package com.neusoft.neumooc.vo;

import com.neusoft.core.common.BaseVO;

/**
 * @ClassName: HomepageSearchVO
 * @Description: 搜索条件类
 * @author Zhenglishen
 * @date 2016年8月2日
 */
public class HomepageSearchVO extends BaseVO {
	public String Searchphotoname; // 搜索照片名称
	public String Searchscreendate; // 搜索上传时间
	public String Searchdescription; // 搜索照片描述

	public String getSearchphotoname() {
		return Searchphotoname;
	}

	public void setSearchphotoname(String searchphotoname) {
		Searchphotoname = searchphotoname;
	}

	public String getSearchscreendate() {
		return Searchscreendate;
	}

	public void setSearchscreendate(String searchscreendate) {
		Searchscreendate = searchscreendate;
	}

	public String getSearchdescription() {
		return Searchdescription;
	}

	public void setSearchdescription(String searchdescription) {
		Searchdescription = searchdescription;
	}
}