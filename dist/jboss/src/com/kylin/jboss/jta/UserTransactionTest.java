package com.kylin.jboss.jta;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class UserTransactionTest {

	public static void main(String[] args) throws NamingException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {

		InitialContext ic = new InitialContext();
		UserTransaction utx = (UserTransaction) ic.lookup("UserTransaction");
	
		System.out.println(utx.getClass());

	}

}
