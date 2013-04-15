package com.example.movie.auth.controller;

import com.example.movie.auth.dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Author: Pramod Bhandari
 * Date: 3/26/13
 * Time: 8:46 PM
 */
public class Logout extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("user");
            System.out.println("Logging out, User Id:" + user.getId());
            //kill session
            session.invalidate();
            //remove cookie
            Cookie cookie;
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equals("auth")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            String redirectUrl = response.encodeRedirectURL(request.getContextPath()+"/auth/login");
            response.sendRedirect(redirectUrl);
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);

    }


}
