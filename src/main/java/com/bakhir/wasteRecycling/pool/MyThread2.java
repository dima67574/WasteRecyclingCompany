
package com.bakhir.wasteRecycling.pool;
import java.sql.Connection;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

class MyThread2 implements Runnable {	

	private static final Logger log = LogManager.getLogger(MyThread2.class);
	ConnectionPool POOL=ConnectionPool.getInstance();         
    public void run(){          
        log.info(" started..." );
        Connection connection = POOL.getConnection();	       
        try {
                Thread.sleep(5000);
        } catch (InterruptedException e) {
            	log.error(e);
        }              
        POOL.releaseConnection(connection);       
        log.info(" finished..." );
    }
}
