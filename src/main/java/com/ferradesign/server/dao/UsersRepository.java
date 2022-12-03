package com.ferradesign.server.dao;

import com.ferradesign.server.Utils;
import com.ferradesign.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UsersRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        return jdbcTemplate.query(
                "select id, login, password, role, email, created from users",
                (rs, rowNum) -> new User(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getInt("role"),
                        rs.getString("email"),
                        rs.getDate("created"))
        );
    }

    public Integer getUserRole(String login, String password) {
        String sql = "select role from users where login = ? and password = ?";
        Integer role;
        try {
            role = jdbcTemplate.queryForObject(sql, Integer.class, login, password);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return role;
    }

    public void addUser(String login, String password, int role, String email) {
        jdbcTemplate.update("INSERT INTO customer(login, password, role, email, created) VALUES (?,?,?,?,?)",
                login, Utils.MD5(password), role, email, new Date());

    }

}
