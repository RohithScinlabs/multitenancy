package com.multitenancy.multitenancy.TenantConnectionProvider;

import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;

import javax.sql.DataSource;
import java.util.Map;


public class CustomMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {
    private Map<String, DataSource> dataSources;

    public CustomMultiTenantConnectionProviderImpl(Map<String, DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    @Override
    protected DataSource selectAnyDataSource() {
        return dataSources.values().iterator().next();
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        DataSource dataSource = dataSources.get(tenantIdentifier);
        if (dataSource != null) {
            return dataSource;
        }
        throw new HibernateException("Tenant not found: " + tenantIdentifier);
    }
}

//    @Autowired
//    private DataSource defaultDataSource;
//
//    @Override
//    protected ConnectionProvider getAnyConnectionProvider() {
//        return new DriverManagerConnectionProviderImpl();
//    }
//
//    @Override
//    protected ConnectionProvider selectConnectionProvider(String tenantIdentifier) {
//        TenantContext.setCurrentSchema(tenantIdentifier);
//
//        DriverManagerConnectionProviderImpl connectionProvider = new DriverManagerConnectionProviderImpl();
//        connectionProvider.configure(getProperties(tenantIdentifier));
//
//        return connectionProvider;
//    }
//
//    private Map<String, Object> getProperties(String tenantIdentifier) {
//        Properties properties = new Properties();
//        properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/" + tenantIdentifier);
//        properties.setProperty(Environment.USER, "root");
//        properties.setProperty(Environment.PASS, "Rohith@123");
//        properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//
//        return typeCastConvert(properties);
//    }
//
//    public static Map<String, Object> typeCastConvert(Properties prop) {
//        Map<String, Object> step2 = (Map<String, Object>) (Map) prop;
//        return step2;
//    }
