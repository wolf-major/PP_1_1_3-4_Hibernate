/*
package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
*/
/*        String sqlCreate = "CREATE TABLE IF NOT EXISTS users (id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50) NOT NULL," +
                "lastName VARCHAR(80) NOT NULL," +
                "age  TINYINT(3) NOT NULL)";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlCreate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*//*

    }

    public void dropUsersTable() {
*/
/*        String sqlDrop = "DROP TABLE IF EXISTS users";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlDrop);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*//*

    }

    public void saveUser(String name, String lastName, byte age) {
*/
/*        String sql = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();

            System.out.printf("User с именем — %s добавлен в базу данных.\n", name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*//*

    }

    public void removeUserById(long id) {
*/
/*        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*//*


    }

    public List<User> getAllUsers() {
*/
/*        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;*//*

    }

    public void cleanUsersTable() {
*/
/*        String sql = "DELETE FROM users";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*//*

    }
}
*/
