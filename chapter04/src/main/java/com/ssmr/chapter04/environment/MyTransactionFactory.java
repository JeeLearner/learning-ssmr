package com.ssmr.chapter04.environment;

import com.ssmr.chapter04.objectfactory.MyTransaction;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

public class MyTransactionFactory implements TransactionFactory {

    @Override
    public void setProperties(Properties properties) {

    }

    @Override
    public Transaction newTransaction(Connection conn) {
        return new MyTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new MyTransaction(dataSource, level, autoCommit);
    }
}
