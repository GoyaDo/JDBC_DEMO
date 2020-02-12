package com.elevengeek.goya.jdbctemplate;

import com.elevengeek.goya.druid.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 * @author cj
 * @create 2020-02-12-17:57
 */
public class JdbcTemplateDemo {
    public static void main(String[] args) {
        //创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

//        String sql = "update tb_user set age = ? where id = ?";

//        String sql = "select * from tb_user where id = ?";

        String sql = "select * from tb_user";

        //调用方法
//        int count = template.update(sql, 26,6);
//        Map<String, Object> map = template.queryForMap(sql,1);
//        List<Map<String, Object>> list = template.queryForList(sql, 1);
//        List<User> userList = template.query(sql, new RowMapper<User>() {
//            @Override
//            public User mapRow(ResultSet resultSet, int i) throws SQLException {
//                User user = new User();
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//
//                user.setId(id);
//                user.setName(name);
//                user.setAge(age);
//                return user;
//            }
//        });
        List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

//        System.out.println(count);
//        System.out.println(map);
//        System.out.println(list);
        for (User user: userList){
            System.out.println(user);
        }
    }
}
