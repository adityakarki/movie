package com.example.movie.auth.dao;

import com.example.movie.auth.dao.mysql.AuthDaoMysqlImpl;

/**
 * Author: Pramod Bhandari
 * Date: 4/2/13
 * Time: 9:28 AM
 */
public class AuthDaoFactory {
    public static AuthDao getAuthDao() throws Exception{
        return new AuthDaoMysqlImpl();
//        if("MYSQL".equalsIgnoreCase("")){
//            return new AuthDaoMysqlImpl();
//        }else if("ORACLE".equalsIgnoreCase("")){
//            return null;
//
//        }else{
//            throw new Exception("DAMN!!!Invalid Database Server :(");
//        }
    }
}
