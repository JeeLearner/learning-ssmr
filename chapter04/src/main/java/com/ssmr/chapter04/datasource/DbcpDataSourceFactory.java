package com.ssmr.chapter04.datasource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class DbcpDataSourceFactory implements DataSourceFactory{

    private Properties props = null;

    @Override
    public void setProperties(Properties properties) {
        this.props = properties;
    }

    @Override
    public DataSource getDataSource() {
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dataSource;
    }
}
