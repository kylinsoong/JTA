package com.kylin.jboss.jta;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TransactionManagerTest {

	public static void main(String[] args) throws NamingException {

		InitialContext ic = new InitialContext();
		ic.lookup("java:TransactionManager");
	}

}
