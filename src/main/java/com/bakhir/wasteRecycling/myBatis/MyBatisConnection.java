package com.bakhir.wasteRecycling.myBatis;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MyBatisConnection {
	private static final Logger log = LogManager.getLogger(MyBatisConnection.class);
	private SqlSessionFactory factory;
	private static MyBatisConnection instance = new MyBatisConnection();

	private MyBatisConnection() {
		try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
	       factory =new SqlSessionFactoryBuilder().build(reader);
	    } catch (Exception e) {
	    	log.error(e.getMessage());
	    }

	}
	public static MyBatisConnection getInstance() {        
        return instance;
    }
	public SqlSessionFactory getSqlSessionFactory(){
		return factory;
	}
	

	

}
