package com.dream.shc.user.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.dream.shc.base.document.BaseDocument;
import com.dream.shc.sys.document.SmallFile;
@Document
public class UseUser extends BaseDocument {
	private String name;
	private String nick;
	private SmallFile photoSmall;
	private int points;
	private Date loginDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public SmallFile getPhotoSmall() {
		return photoSmall;
	}
	public void setPhotoSmall(SmallFile photoSmall) {
		this.photoSmall = photoSmall;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
}
