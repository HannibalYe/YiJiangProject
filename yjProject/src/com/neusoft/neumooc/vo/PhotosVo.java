package com.neusoft.neumooc.vo;

import com.neusoft.core.common.BaseVO;

/**
 * @ClassName: PhotoslistVo
 * @Description: 图片相册类
 * @author HN
 * @date 2016年7月25日
 */
public class PhotosVo extends BaseVO {
	private String photoid;         // 相片编号
	private String photoname;       // 相片名称
	private String albumid;         // 相册名
	private String description;     // 相片描述
	private String phototype;       // 相片路径
	private String screendate;      // 上传时间

	public String getScreendate() {
		return screendate;
	}

	public void setScreendate(String screendate) {
		this.screendate = screendate;
	}

	public String getPhotoid() {
		return photoid;
	}

	public void setPhotoid(String photoid) {
		this.photoid = photoid;
	}

	public String getPhotoname() {
		return photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	public String getAlbumid() {
		return albumid;
	}

	public void setAlbumid(String albumid) {
		this.albumid = albumid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhototype() {
		return phototype;
	}

	public void setPhototype(String phototype) {
		this.phototype = phototype;
	}

}
