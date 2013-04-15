package com.example.movie.auth.dao;

import com.example.movie.auth.dto.User;

/**
 * Author: Pramod Bhandari
 * Date: 4/2/13
 * Time: 9:28 AM
 */
public interface AuthDao {

    User login(String username, String password) throws Exception;

    void setRememberToken(User user, String cookieToken) throws Exception;

    User getUserFromAuthToken(String authToken) throws Exception;

    User signup(String firstname,String lastname, String username, String password) throws Exception;

    Boolean existsUsername(String username) throws Exception;

}
