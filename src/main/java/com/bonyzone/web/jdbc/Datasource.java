package com.bonyzone.web.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.bonyzone.web.util.ApplicationUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Datasource {

	private Properties props;
    private ComboPooledDataSource cpds;
    private static Datasource datasource;
    private static Logger logger = Logger.getLogger(Datasource.class);

    private Datasource() throws IOException, SQLException {
    	
        logger.info("Reading datasource.properties from classpath");
        props = ApplicationUtils.getProperties("datasource.properties");
        cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl(props.getProperty("jdbcUrl"));
        cpds.setUser(props.getProperty("username"));
        cpds.setPassword(props.getProperty("password"));

        cpds.setInitialPoolSize(new Integer((String) props.getProperty("initialPoolSize")));
        cpds.setAcquireIncrement(new Integer((String) props.getProperty("acquireIncrement")));
        cpds.setMaxPoolSize(new Integer((String) props.getProperty("maxPoolSize")));
        cpds.setMinPoolSize(new Integer((String) props.getProperty("minPoolSize")));
        cpds.setMaxStatements(new Integer((String) props.getProperty("maxStatements")));

    }

    public static Datasource getInstance() throws IOException, SQLException {
        if (datasource == null) {
              datasource = new Datasource();
              return datasource;
            } else {
              return datasource;
            }
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }
}
