package com.bakhir.wasteRecycling.dAO.impl;

import com.bakhir.wasteRecycling.pool.ConnectionPool;

public abstract class AbstractJDBC {
	protected static final ConnectionPool POOL = ConnectionPool.getInstance();
	
}
