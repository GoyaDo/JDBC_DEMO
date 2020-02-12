package com.elevengeek.goya.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author cj
 * @create 2020-02-12-16:40
 */
public class C3P0Demo {
    public static void main(String[] args) throws SQLException {

        //创建数据库连接池对象
        DataSource dataSource = new ComboPooledDataSource();
        //获取连接对象
        Connection connection = dataSource.getConnection();

        //打印连接对象
        System.out.println(connection);
    }
}
