package com.bakhir.wasteRecycling.pool;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConnectionPool {
	private static final Logger log = LogManager.getLogger(ConnectionPool.class);
	private static ConnectionPool instance= new ConnectionPool();	
	private  BlockingQueue<Connection> pool;
	private static int countConnection;	
	private String driver;
	private String url;
	private String username;
	private String password;
	private int size;
	private Properties props;
	private Connection connection = null;
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	private ConnectionPool() {		
		props = new Properties();
		try(FileInputStream in= new FileInputStream("src/main/resources/database.properties");) {
			props.load(in);
		} catch (FileNotFoundException e2) {
			log.error(e2.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}		
		
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("password");
		size= Integer.valueOf(props.getProperty("size"));
		pool = new ArrayBlockingQueue<>(size);
	}

	private Connection createConnection() {
		 
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			log.error(e.getMessage());
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage());
		}
		return connection;
	}

	public static ConnectionPool getInstance() {			
		return instance;
	}
	public Connection getConnection() { 
		
		Connection connection = pool.poll(); 
		if (connection!=null){ 
		return connection; 
		} 
		lock.writeLock().lock(); 
		if ( countConnection < size) { 
		pool.add(createConnection()); 
		countConnection++; 
		log.info("Count connection = " + countConnection); 
		} 
		try { 
		connection = pool.take(); 
		} catch (InterruptedException e) { 
			log.error(e.getMessage()); 
		} 
		lock.writeLock().unlock(); 
		return connection; 

		}
	

	public void releaseConnection(Connection connection) {
		pool.add(connection);
	}
}
