package net.iouhase.gilbert.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class RepositoryConfig {

    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://iouhase.net:3306/gilbert");
        dataSource.setUsername("user");
        dataSource.setPassword("26Uj96MSlPMV4o3aHqIypWcu");

        return dataSource;
    }
}
