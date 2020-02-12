package com.elevengeek.goya.demo;

import com.elevengeek.goya.util.JDBCUtils;
import java.sql.*;

/**
 * @author cj
 * @create 2020-02-12-13:18
 */
public class JdbcDemo {
    public static void main(String[] args) {
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
//            //注册驱动
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //获取数据库连接对象
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","123456");
            connection = JDBCUtils.getConnection();
            //定义sql语句
//            String sql = "select * from tb_user";
            String sql = "select * from tb_user where name = ? and age = ?";
            //获取执行sql的对象Statement
//            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement(sql);
            //执行sql
//            int count = statement.executeUpdate(sql);
//            resultSet = statement.executeQuery(sql);
            //给？赋值
            preparedStatement.setString(1,"goya");
            preparedStatement.setInt(2,22);
            resultSet = preparedStatement.executeQuery();
            //处理结果
//            System.out.println(count);
//            //让光标向下移动一行
//            resultSet.next();
//            //获取数据
//            int id = resultSet.getInt(1);
//            String name = resultSet.getString("name");
//            int age = resultSet.getInt("age");
//            System.out.println(id+"---"+name+"---"+age);
            while(resultSet.next()){
                //获取数据
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                    System.out.println(id+"---"+name+"---"+age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            JDBCUtils.close(resultSet,preparedStatement,connection);
        }
    }
}
