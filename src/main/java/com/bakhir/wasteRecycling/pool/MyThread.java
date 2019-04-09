package com.bakhir.wasteRecycling.pool;
import java.sql.Connection;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

class MyThread extends Thread {	
	private static final Logger log = LogManager.getLogger(MyThread.class);
	ConnectionPool POOL=ConnectionPool.getInstance();   
	
	public MyThread(String name){
        super(name);
    }
      
    public void run(){          
        log.info(Thread.currentThread().getName()+" started..." );
        Connection connection = POOL.getConnection();	
        log.info( Thread.currentThread().getName() + " Begin  with conn: " + connection);
        try {
                Thread.sleep(2000);
        } catch (InterruptedException e) {
            	log.error(e);
        }
        log.info(Thread.currentThread().getName() + " End  with conn: " + connection);       
        POOL.releaseConnection(connection);       
        log.info(Thread.currentThread().getName()+" finished..." );
    }
}
