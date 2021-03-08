package com.zjs.saturn.common.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@AutoConfigureAfter({DruidDataSourceConfiguration.class})
@MapperScan(basePackages = {"com.hupan.jupiter.**.dao"})
public class TransactionConfig implements TransactionManagementConfigurer {
    @Autowired
    private DataSource mDataSource;

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(mDataSource);
    }

}