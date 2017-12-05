package com.ssmr.chapter10.annotation.config;


import com.ssmr.chapter09.pojo.JuiceMaker2;
import com.ssmr.chapter09.pojo.Source;
import com.ssmr.chapter10.annotation.condition.DataSourceCondition;
import com.ssmr.chapter10.annotation.pojo.Role;
import com.ssmr.chapter10.annotation.service.impl.RoleServiceImpl;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

//@ComponentScan(basePackageClasses = { Role.class, RoleServiceImpl.class })
// @ComponentScan(basePackages = {"com.ssm.chapter10.annotation.pojo","com.ssm.chapter10.annotation.service"})
// @ComponentScan(basePackages = {"com.ssm.chapter10.annotation.pojo","com.ssm.chapter10.annotation.service"}, basePackageClasses = {Role.class, RoleServiceImpl.class})
//@ComponentScan(basePackageClasses = { Role.class, RoleServiceImpl.class },
//		excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern="com.ssm.chapter10.annotation.config.AutowiredConfig")})

//引入xml配置的数据源
//@ImportResource({"classpath:spring-dataSource.xml"})
//使用多个配置类
//@Import({ApplicationConfig2.class, ApplicationConfig3.class})
//引入属性文件
@PropertySource(value={"classpath:database-config.properties"}, ignoreResourceNotFound=true)
//加载属性文件（便于解析属性占位符）
@ComponentScan(basePackages = {"com.ssmr.chapter10.anotation"})
public class ApplicationConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
        条件化装配bean
     */
    @Bean(name = "dataSource")
	@Conditional({DataSourceCondition.class})
	public DataSource getDataSource(
			@Value("${jdbc.database.driver}") String driver,
			@Value("${jdbc.database.url}") String url,
			@Value("${jdbc.database.username}") String username,
			@Value("${jdbc.database.password}") String password) {
		Properties props = new Properties();
		props.setProperty("driver", driver);
		props.setProperty("url", url);
		props.setProperty("username", username);
		props.setProperty("password", password);
		DataSource dataSource = null;
		try {
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}

   /* @Bean(name = "dataSource")
    public DataSource getDataSource() {
        Properties props = new Properties();
        props.setProperty("driver", "com.mysql.jdbc.Driver");
        props.setProperty("url", "jdbc:mysql://localhost:3306/chapter10");
        props.setProperty("username", "root");
        props.setProperty("password", "123456");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }*/

    @Bean(name = "juiceMaker2", initMethod = "init", destroyMethod = "myDestroy")
    public JuiceMaker2 initJuiceMaker2() {
        JuiceMaker2 juiceMaker2 = new JuiceMaker2();
        juiceMaker2.setBeverageShop("贡茶");
        Source source = new Source();
        source.setFruit("橙子");
        source.setSize("大杯");
        source.setSugar("少糖");
        juiceMaker2.setSource(source);
        return juiceMaker2;
    }
}