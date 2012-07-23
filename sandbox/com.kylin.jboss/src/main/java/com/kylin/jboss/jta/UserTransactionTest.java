package com.kylin.jboss.jta;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class UserTransactionTest {

	public static void main(String[] args) throws NamingException, NotSupportedException, SystemException {

		InitialContext ic = new InitialContext();
		UserTransaction utx = (UserTransaction) ic.lookup("UserTransaction");
		
		utx.begin();

	}

}
