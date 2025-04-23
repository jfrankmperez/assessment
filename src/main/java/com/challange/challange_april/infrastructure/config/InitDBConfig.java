package com.challange.challange_april.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class InitDBConfig {

    @Bean
    DataSourceInitializer initializer(DataSource dataSource) {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);

        ResourceDatabasePopulator populator =new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db/migration/createTables.sql"));
        initializer.setDatabasePopulator(populator);
        return initializer;
    }
}
