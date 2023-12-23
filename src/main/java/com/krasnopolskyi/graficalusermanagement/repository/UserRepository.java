package com.krasnopolskyi.graficalusermanagement.repository;

import com.krasnopolskyi.graficalusermanagement.datasource.MyDataSource;
import com.krasnopolskyi.graficalusermanagement.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository {
    public int save(Long id, String name, String password) throws SQLException {
        String sql = "insert into users (id, name, password) values(?,?,?)";
        try (Connection con = MyDataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setLong(1, id);
            pst.setString(2, name);
            pst.setString(3, password);
            return pst.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Something went wrong");
        }
    }

    public boolean isIdExist(Long id) throws SQLException {
        String sql = "select * from users where id=?";
        try (Connection con = MyDataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setLong(1, id);
            ResultSet resultSet = pst.executeQuery();
            boolean isExist = resultSet.next();
            resultSet.close();
            return isExist;
        } catch (SQLException e) {
            throw new SQLException("Sorry something went wrong");
        }
    }

    public Optional<User> getRandom() throws SQLException {
        String sql = "SELECT id, name FROM users ORDER BY RAND() LIMIT 1";
        User user = null;
        try (Connection con = MyDataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getLong("id"), resultSet.getString("name"));
            }
            resultSet.close();
            return Optional.of(user);
        } catch (SQLException e) {
            throw new SQLException("Something went wrong");
        }
    }
}
