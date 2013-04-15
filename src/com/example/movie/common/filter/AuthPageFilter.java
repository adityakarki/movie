package com.example.movie.common.filter;

import com.example.movie.auth.dao.AuthDao;
import com.example.movie.auth.dao.AuthDaoFactory;
import com.example.movie.auth.dto.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: pramod
 * Date: 4/13/13
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class AuthPageFilter implements Filter {
    public void destroy() {
    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session;
        User user;
        Cookie cookie;
        AuthDao dao;
        String url = request.getServletPath();
        boolean loggedIn = false;
        try {
            session = request.getSession(false);

            if (session != null && session.getAttribute("user") != null) {
                loggedIn = true;
            } else {
                user = null;
                Cookie[] cookies = request.getCookies();
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if (cookie.getName().equals("auth")) {
                        dao = AuthDaoFactory.getAuthDao();
                        String authToken = cookie.getValue();
                        user = dao.getUserFromAuthToken(authToken);
                        if (user != null) {
                            session = request.getSession();
                            session.setAttribute("user", user);
                            loggedIn = true;
                        }
                        break;

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(loggedIn){
            String redirectUrl = response.encodeRedirectURL(request.getContextPath()+"/app/home");
            response.sendRedirect(redirectUrl);
            return;
        }

        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
