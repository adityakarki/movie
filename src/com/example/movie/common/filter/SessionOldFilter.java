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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: pramod
 * Date: 4/13/13
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class SessionOldFilter implements Filter {
    public void destroy() {
    }

    private boolean shouldExcludeFilter(String url) {
        boolean exclude = false;
        String excludeTypes = "js, css, ico, png, jpg, gif";
        String[] splitUrl = url.split(Pattern.quote("."));
        String urlType = splitUrl[Array.getLength(splitUrl) - 1];
        List<String> excludeList = new ArrayList<String>();

        StringTokenizer token = new StringTokenizer(excludeTypes, ",");
        while (token.hasMoreTokens()) {
            excludeList.add(token.nextToken().trim());
        }

        if (excludeList.contains(urlType)) exclude = true;


        return exclude;
    }

    private boolean onlyLoggedOut(String url) {
        boolean onlyLoggedOut = false;
        String pages = "auth, signup";
        String page = url.substring(1);

        List<String> pageList = new ArrayList<String>();

        StringTokenizer token = new StringTokenizer(pages, ",");
        while (token.hasMoreTokens()) {
            pageList.add(token.nextToken().trim());
        }

        if (pageList.contains(page)) onlyLoggedOut = true;
        return onlyLoggedOut;

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

        if (!shouldExcludeFilter(url)) {
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
            if (!loggedIn && onlyLoggedOut(url)) {
                chain.doFilter(req, resp);
                return;
            } else if (loggedIn && onlyLoggedOut(url)) {
                response.sendRedirect("/home");
                return;
            } else if (loggedIn) {
                chain.doFilter(req, resp);
                return;
            } else {
                response.sendRedirect("/auth");
                return;
            }


        }

        chain.doFilter(req, resp);


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
