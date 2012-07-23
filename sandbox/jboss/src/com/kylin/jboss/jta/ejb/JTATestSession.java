package com.kylin.jboss.jta.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;

@Stateless
@Remote(JTATestService.class)
public class JTATestSession implements JTATestService {
	
	private final static Logger logger = Logger.getLogger(JTATestService.class);

	public void testTransactionManager() throws Exception {

		logger.info("TransactionManager Test Start");
		
		InitialContext ic = new InitialContext();
		TransactionManager utm = (TransactionManager) ic.lookup("java:/TransactionManager");
		
		System.out.println(utm.getTransaction());
		System.out.println(utm.getClass());

		logger.info("TransactionManager Test End");
	}

	public void testUserTransaction() throws Exception {

		logger.info("UserTransaction Test Start");
		
		InitialContext ic = new InitialContext();
		UserTransaction utx = (UserTransaction) ic.lookup("UserTransaction");
	
		System.out.println(utx.getClass());
		
		logger.info("UserTransaction Test End");
	}

}
