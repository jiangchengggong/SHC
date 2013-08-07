package com.dream.shc.main.dao;

import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import com.mongodb.gridfs.GridFSDBFile;

public interface GridFSDao {
	/**
	 * 通过InputStream保存文件
	 * 2013-8-6
	 * String
	 */
	public String saveFile(InputStream is,String fileName,String fileType);
	/**
	 * 通过 MultipartFile保存文件
	 * 2013-8-6
	 * String
	 */
	public String saveFile(MultipartFile photoFile,String fileType);
	/**
	 * 通过名称查询一个文件
	 * 2013-8-6
	 * GridFSDBFile
	 */
	public GridFSDBFile getFileByName(String fileName,String fileType);
	/**
	 * 通过ID查询一个文件
	 * 2013-8-6
	 * GridFSDBFile
	 */
	public GridFSDBFile getFileById(String id,String fileType);

}
