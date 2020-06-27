package com.boot.security.dao;

import com.boot.security.model.Permission;
import com.boot.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
  @Autowired
  JdbcTemplate jdbcTemplate;

  public User getUserByUsername(String username) {
    String sql = "select id,username,password,fullname from t_user where username = ?";
    List<User> list = jdbcTemplate.query(sql, new Object[]{username}, new BeanPropertyRowMapper<>(User.class));
    if (list == null && list.size() <= 0) {
      return null;
    }
    return list.get(0);
  }

  //根据用户id查询用户权限
  public List<String> findPermissionsByUserId(String userId) {
    String sql = "SELECT * FROM t_permission WHERE id IN(\n" + "SELECT permission_id FROM t_role_permission WHERE role_id IN(\n" + "\tSELECT role_id FROM t_user_role WHERE user_id = ? \n" + ")\n" + ")";
    List<Permission> list = jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(Permission.class));
    List<String> permissions = new ArrayList<>();

    list.forEach(e -> {
      permissions.add(e.getCode());
    });
    return permissions;
  }
}
