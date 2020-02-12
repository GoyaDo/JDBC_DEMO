package com.elevengeek.goya.demo;

import com.elevengeek.goya.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author cj
 * @create 2020-02-12-16:07
 */
public class JdbcDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        try {
            connection = JDBCUtils.getConnection();

            //开启事务
            connection.setAutoCommit(false);

            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";

            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);

            preparedStatement1.setDouble(1,500);
            preparedStatement1.setInt(2,1);

            preparedStatement2.setDouble(1,500);
            preparedStatement2.setInt(2,2);

            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();

            //事务的提交
            connection.commit();

        } catch (Exception e) {
            if (connection != null){
                //事务的回滚
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(preparedStatement1,connection);
            JDBCUtils.close(preparedStatement2,null);
        }
    }
}
