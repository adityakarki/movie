package com.example.movie.auth.controller;

import com.example.movie.auth.dao.AuthDao;
import com.example.movie.auth.dao.AuthDaoFactory;
import com.example.movie.auth.dto.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

/**
 * Author: Pramod Bhandari
 * Date: 3/26/13
 * Time: 8:46 PM
 */
public class Login extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AuthDao dao;
        String username = new String();
        String password = new String();
        String remember = new String();
        User user;
        try {
            dao = AuthDaoFactory.getAuthDao();
            username = request.getParameter("username");
            password = request.getParameter("password");
            remember = request.getParameter("remember");
            user = dao.login(username, password);
            System.out.println("User auth, Id:" + user.getId());
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            if (remember!= null && remember.equals("true")) {
                String cookieToken = UUID.randomUUID().toString();
                Cookie cookie = new Cookie("auth", cookieToken);
                cookie.setMaxAge(30 * 24 * 60 * 60);
                response.addCookie(cookie);
                dao.setRememberToken(user, cookieToken);
            }
            String redirectUrl = response.encodeRedirectURL(request.getContextPath()+"/app/home");
            response.sendRedirect(redirectUrl);
        } catch (Exception e) {
            e.printStackTrace();
            String redirectUrl = response.encodeRedirectURL(request.getContextPath()+"/auth/login");
            response.sendRedirect(redirectUrl);
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        RequestDispatcher view;
        view = request.getRequestDispatcher("/pages/auth/login.jsp");
        view.forward(request, response);
    }
}
