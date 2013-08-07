package com.dream.shc.user.document;

import java.util.Date;


import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;


import com.dream.shc.base.document.BaseDocument;
import com.dream.shc.main.document.Message;
import com.dream.shc.other.document.SNS;
import com.dream.shc.sys.document.SmallFile;
@Document(collection="user")
public class User extends BaseDocument {
	private String email;
	private String account;
	private String password;
	private String name;
	private String gender;
	private Date birthDate;
	private String nick;
	private String bio;
	@Transient
	private MultipartFile photoFile;
	private SmallFile photoLarge;
	private SmallFile photoMiddle;
	private SmallFile photoSmall;
	private int points;
	private Double msb;
	private Double level;
	private UseUser []follow;
	private UseUser []follower;
	private Message []messages;
	private int commentCount;
	private SNS sns;
	private UserExperience userExperience;
	private String type;
	private Student student;
	private Teacher teacher;
	private Date loginDate;
	private boolean isSingle;

	public User() {
		
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public SmallFile getPhotoLarge() {
		return photoLarge;
	}

	public void setPhotoLarge(SmallFile photoLarge) {
		this.photoLarge = photoLarge;
	}

	public SmallFile getPhotoMiddle() {
		return photoMiddle;
	}

	public void setPhotoMiddle(SmallFile photoMiddle) {
		this.photoMiddle = photoMiddle;
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
	public Double getMsb() {
		return msb;
	}
	public void setMsb(Double msb) {
		this.msb = msb;
	}
	public Double getLevel() {
		return level;
	}
	public void setLevel(Double level) {
		this.level = level;
	}
	public UseUser[] getFollow() {
		return follow;
	}
	public void setFollow(UseUser[] follow) {
		this.follow = follow;
	}
	public UseUser[] getFollower() {
		return follower;
	}
	public void setFollower(UseUser[] follower) {
		this.follower = follower;
	}
	public Message[] getMessages() {
		return messages;
	}
	public void setMessages(Message[] messages) {
		this.messages = messages;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public SNS getSns() {
		return sns;
	}
	public void setSns(SNS sns) {
		this.sns = sns;
	}
	public UserExperience getUserExperience() {
		return userExperience;
	}
	public void setUserExperience(UserExperience userExperience) {
		this.userExperience = userExperience;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public boolean isSingle() {
		return isSingle;
	}
	public void setSingle(boolean isSingle) {
		this.isSingle = isSingle;
	}

    
	
}
