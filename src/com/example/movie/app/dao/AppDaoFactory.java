package com.example.movie.app.dao;

import com.example.movie.app.dao.mysql.AppDaoMysqlImpl;

/**
 * Author: Pramod Bhandari
 * Date: 4/3/13
 * Time: 9:16 AM
 */
public class AppDaoFactory {
    public static AppDao getAppDao() throws Exception{
        return new AppDaoMysqlImpl();
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
