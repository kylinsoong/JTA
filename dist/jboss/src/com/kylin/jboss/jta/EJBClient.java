package com.kylin.jboss.jta;

import javax.naming.InitialContext;

import com.kylin.jboss.jta.ejb.JTATestService;

public class EJBClient {

	public static void main(String[] args) throws Exception {
		
		InitialContext ic = new InitialContext();
		
		JTATestService service = (JTATestService) ic.lookup("JTATestSession/remote-com.kylin.jboss.jta.ejb.JTATestService");
		
//		service.testUserTransaction();
		
		service.testTransactionManager();
	}

}
