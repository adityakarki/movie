package com.example.movie.auth.dao.mysql;

import com.example.movie.common.BaseDao;
import com.example.movie.auth.dto.User;

/**
 * Author: Pramod Bhandari
 * Date: 4/3/13
 * Time: 9:20 AM
 */
public class AuthDaoMysql extends BaseDao {
    public User login(String username, String password) throws Exception {
        User user = null;
        query = "Select * from user where username=? and password=md5(?)";
        try {
            connect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            System.out.println("SQL===========================================================");
            System.out.println(preparedStatement);
            System.out.println("SQL===========================================================");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setLastName(resultSet.getString("lastname"));

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }

        return user;
    }

    public void setRememberToken(User user, String cookieToken) throws Exception {
        query = "update user set authToken=? where id=?";

        try {
            connect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cookieToken);
            preparedStatement.setInt(2, user.getId());

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }


    public User getUserFromAuthToken(String authToken) throws Exception {
        User user = null;
        query = "Select * from user where authToken=?";
        try {
            connect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, authToken);
            System.out.println("SQL===========================================================");
            System.out.println(preparedStatement);
            System.out.println("SQL===========================================================");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }

        return user;
    }

    public User signup(String firstname, String lastname, String username, String password) throws Exception {
        query = "insert into user (firstname,lastname,username, password) values (?,?,?,md5(?))";

        User user = null;

        try {
            connect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            user = new User(firstname, lastname, username);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
        return user;
    }

    public Boolean existsUsername(String username) throws Exception {
        Boolean existsUsername=true;

        query = "Select * from user where username=?";
        try {
            connect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            System.out.println(preparedStatement);

            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst() ) {
                existsUsername=false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }

        return existsUsername;
    }
}
