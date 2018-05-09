
package com.neusoft.neumooc.vo;

/**
 * @ClassName: Album
 * @Description: TODO
 * @author Fuyongjun
 * @params albumName：专辑名字，description：描述 ，    albumId：专辑编号
 * @date 2016年7月25日
 */
public class AlbumVo {
	public String albumname; // 专辑名字
	public String description;// 专辑描述
	public String albumid; // 专辑编号
	public String 	builddate;
	public String getAlbumname() {
		return albumname;
	}
	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}
	public String getBuilddate() {
		return builddate;
	}
	public void setBuilddate(String builddate) {
		this.builddate = builddate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAlbumid() {
		return albumid;
	}
	public void setAlbumid(String albumid) {
		this.albumid = albumid;
	}

	
}
