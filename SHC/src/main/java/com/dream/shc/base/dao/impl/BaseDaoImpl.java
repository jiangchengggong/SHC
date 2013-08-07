package com.dream.shc.base.dao.impl;



import javax.annotation.Resource;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.dream.shc.base.dao.BaseDao;

public abstract  class BaseDaoImpl<T> implements BaseDao<T> {
	@Autowired
	protected Logger logger;
	
	private MongoTemplate mongoTemplate;

	@Resource(name="mongoTemplate")
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
	
	


}
