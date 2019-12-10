package io.seata.mp.starter;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

import io.seata.rm.datasource.DataSourceProxy;

/**
 * 
 * @author 陈健斌
 * @date 2019/12/10
 */
@Configuration
@ConditionalOnClass(DataSourceProxy.class)
public class DataSourceProxyAutoConfiguration {
    @Bean(name = "druidDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Primary
    @Bean("dataSource")
    @Lazy
    public DataSourceProxy dataSource(@Qualifier(value = "druidDataSource") DataSource druidDataSource) {
        return new DataSourceProxy(druidDataSource);
    }
}
