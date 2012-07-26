package com.kylin.jta.jboss5.ejb;

public interface JTATestService {

	public abstract void testTransactionManager() throws Exception;
	
	public abstract void testUserTransaction() throws Exception;
}
