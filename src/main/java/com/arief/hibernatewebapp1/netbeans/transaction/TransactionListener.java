package com.arief.hibernatewebapp1.netbeans.transaction;

import org.hibernate.Session;


public interface TransactionListener {
    public void onRunningTransactionWithOpenSession(Session s);
//    public void onRunningTransactionWithResult(Object o);
}
