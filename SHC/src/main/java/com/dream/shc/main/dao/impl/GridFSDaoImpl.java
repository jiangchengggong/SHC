package com.dream.shc.main.dao.impl;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.dream.shc.main.constants.MainConstants;
import com.dream.shc.main.dao.GridFSDao;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
@Repository("gridFSDao")
public class GridFSDaoImpl implements GridFSDao {
	@Autowired
	protected Logger logger;
	private GridFS gfsPhoto;
	private GridFS gfsVideo;
	private GridFS gfsVoice;
	private GridFS gfsOther;
	
	private MongoTemplate mongoTemplateFS;
	public MongoTemplate getMongoTemplateFS() {
		return mongoTemplateFS;
	}
	@Resource(name="mongoTemplateFS")
	public void setMongoTemplateFS(MongoTemplate mongoTemplateFS) {
		this.mongoTemplateFS = mongoTemplateFS;
	}
    /**
     * 鎸夊垎绫�杩斿洖涓�釜GridFS
     * 2013-8-6
     * GridFS
     */
	private GridFS getGfs(String fileType) {
		if(MainConstants.FILE_TYPE_PHOTO.equals(fileType)){
			if(gfsPhoto==null){
				gfsPhoto = new GridFS(mongoTemplateFS.getDb(), MainConstants.FILE_TYPE_PHOTO);
			}
			return gfsPhoto;
		}else if(MainConstants.FILE_TYPE_VIDEO.equals(fileType)){
			if(gfsVideo==null){
				gfsVideo =  new GridFS(mongoTemplateFS.getDb(), MainConstants.FILE_TYPE_VIDEO);
			}
			return gfsVideo;
		}else if(MainConstants.FILE_TYPE_VOICE.equals(fileType)){
			if(gfsVoice==null){
				gfsVoice =  new GridFS(mongoTemplateFS.getDb(), MainConstants.FILE_TYPE_VOICE);
			}
			return gfsVoice;
		}else{
			if(gfsOther==null){
				gfsOther =  new GridFS(mongoTemplateFS.getDb(), MainConstants.FILE_TYPE_OTHER);
			}
			return gfsOther;
		}
	}


	public String saveFile(InputStream is, String fileName,String fileType) {
		GridFSInputFile gfsFile;
		gfsFile = getGfs(fileType).createFile(is);
		gfsFile.setFilename(fileName);
		gfsFile.save();
		return gfsFile.getId().toString();
	}

	public String saveFile(MultipartFile photoFile,String fileType) {
		GridFSInputFile gfsFile;
		try {
			gfsFile = getGfs(fileType).createFile(photoFile.getInputStream());
			gfsFile.setFilename(photoFile.getName());
			gfsFile.setContentType(photoFile.getContentType());
			gfsFile.save();
			return gfsFile.getId().toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public GridFSDBFile getFileByName(String fileName,String fileType) {
		return getGfs(fileType).findOne(fileName);
	}


	public GridFSDBFile getFileById(String id,String fileType) {
		return getGfs(fileType).findOne(new ObjectId(id));
	}


}
