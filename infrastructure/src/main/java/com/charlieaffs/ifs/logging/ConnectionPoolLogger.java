package com.charlieaffs.ifs.logging;

import java.sql.Connection;

import com.mchange.v2.c3p0.ConnectionCustomizer;

public class ConnectionPoolLogger implements ConnectionCustomizer {

	  private static final TILogger logger = TILogger.getLog();
	    private int activeConnections = 0;
	    private int acquiredConnections = 0;

	    @Override
		public void onAcquire(Connection c, String pdsIdt) {
	        logger.info("onAcquire: Connection acquired from database : " + c
	                + " [" + pdsIdt + "]");
	        acquiredConnections++;
	        logger.info("onAcquire: Total Open Connections in Pool : " + acquiredConnections);
	    }

	    @Override
		public void onDestroy(Connection c, String pdsIdt) {
	        logger.info("onDestroy: Connection closed with database : " + c + " ["
	                + pdsIdt + "]");
	        acquiredConnections--;
	        logger.info("onDestroy: Total Open Connections in Pool : " + acquiredConnections);

	    }

	    @Override
		public void onCheckOut(Connection c, String pdsIdt) {
	        logger.info("onCheckOut: Connection from pool provide to application : "
	                + c + " [" + pdsIdt + "]");
	        activeConnections++;
	        logger.info("onCheckOut: Total Active Connections in Pool : " + activeConnections);
	    }

	    @Override
		public void onCheckIn(Connection c, String pdsIdt) {
	        logger.info("onCheckIn: Connection returned to pool from application : "
	                + c + " [" + pdsIdt + "]");
	        activeConnections--;
	        logger.info("onCheckIn: Total Active Connections in Pool : " + activeConnections);

	    }

}
