
package com.arief.hibernatewebapp1.netbeans.setup;

import java.util.Properties;

public class HibernateConfiguration {
    private static Properties hibernateProperties(){
        Properties props = new Properties();
        
        props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        props.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/orm_db7");
        props.put("hibernate.connection.username", "arief");
        props.put("hibernate.connection.password", "arief");
        

        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.show_sql", "true");
        
        
        return props;
    }
    
    public static Properties getHibernateProperties(){
        return hibernateProperties();
    }
}
