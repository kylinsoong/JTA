package org.jboss.narayana.example.jta;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

public class TransactionExample {

    public static void main(String[] args) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, InterruptedException {

        System.setProperty("ObjectStoreBaseDir", "target");
        TransactionExample txeg = new TransactionExample();
        txeg.commitUserTransaction();
        txeg.commitTransactionManager();
        txeg.rollbackUserTransaction();
        txeg.setRollbackOnly();
        txeg.transactionStatus();
        txeg.transactionTimeout();
        
        System.out.println("\nTransactionExample Exit\n");
    }

    void transactionTimeout() throws SystemException, NotSupportedException, InterruptedException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
        UserTransaction utx = com.arjuna.ats.jta.UserTransaction.userTransaction();
        utx.setTransactionTimeout(1);
        utx.begin();
        Thread.sleep(1500);
        try {
            utx.commit();
        } catch (RollbackException e) {
            e.printStackTrace();
        }
    }

    void transactionStatus() throws NotSupportedException, SystemException {
        UserTransaction utx = com.arjuna.ats.jta.UserTransaction.userTransaction();
        utx.begin();
        
        if (utx.getStatus() != Status.STATUS_ACTIVE){
            throw new RuntimeException("transaction should have been active");
        }
        
        utx.setRollbackOnly();
        
        if (utx.getStatus() != Status.STATUS_MARKED_ROLLBACK){
            throw new RuntimeException("transaction should have been marked rollback only");
        }
        
        utx.rollback();
        
        if (utx.getStatus() != Status.STATUS_NO_TRANSACTION){
            throw new RuntimeException("transaction should not exist");
        }
    }

    void setRollbackOnly() throws NotSupportedException, SystemException, SecurityException, IllegalStateException, HeuristicMixedException, HeuristicRollbackException {
        TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
        tm.begin();
        tm.setRollbackOnly();
        try {
            tm.commit();
        } catch (RollbackException e) {
            e.printStackTrace();
        }
    }

    void rollbackUserTransaction() throws NotSupportedException, SystemException {
        UserTransaction utx = com.arjuna.ats.jta.UserTransaction.userTransaction();
        utx.begin();
        utx.rollback();
    }

    void commitTransactionManager() throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
        TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
        tm.begin();
        tm.commit();
    }

    void commitUserTransaction() throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
        
        UserTransaction utx = com.arjuna.ats.jta.UserTransaction.userTransaction();
        utx.begin();
        utx.commit();
    }

}
