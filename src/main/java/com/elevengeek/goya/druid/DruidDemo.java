package com.elevengeek.goya.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author cj
 * @create 2020-02-12-16:47
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //定义配置文件

        //加载配置文件
        Properties properties = new Properties();
        InputStream inputStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(inputStream);
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();

        System.out.println(connection);
    }
}
