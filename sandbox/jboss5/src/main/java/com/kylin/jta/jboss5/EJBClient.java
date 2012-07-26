package com.kylin.jta.jboss5;

import javax.naming.InitialContext;

import com.kylin.jta.jboss5.ejb.JTATestService;


public class EJBClient {

	public static void main(String[] args) throws Exception {
		
		InitialContext ic = new InitialContext();
		
		JTATestService service = (JTATestService) ic.lookup("JTATestSession/remote-com.kylin.jboss.jta.ejb.JTATestService");
		
//		service.testUserTransaction();
		
		service.testTransactionManager();
	}

}
