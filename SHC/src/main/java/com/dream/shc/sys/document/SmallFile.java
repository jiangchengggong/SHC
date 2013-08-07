package com.dream.shc.sys.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.dream.shc.base.document.BaseDocument;

@Document
public class SmallFile extends BaseDocument{
	private String fileName;
	private int size;
	private String fileType;
	private byte[] byteObj;
	private Date createDate;

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getByteObj() {
		return byteObj;
	}
	public void setByteObj(byte[] byteObj) {
		this.byteObj = byteObj;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
