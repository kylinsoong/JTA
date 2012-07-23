package com.kylin.jboss.jta.ejb;

public interface JTATestService {

	public abstract void testTransactionManager() throws Exception;
	
	public abstract void testUserTransaction() throws Exception;
}
