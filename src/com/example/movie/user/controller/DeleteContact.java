package com.example.movie.user.controller;

import com.example.movie.auth.dto.User;
import com.example.movie.user.dao.AppDao;
import com.example.movie.user.dao.AppDaoFactory;
import com.example.movie.user.dto.Contact;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author: Pramod Bhandari
 * Date: 4/3/13
 * Time: 11:11 PM
 */
public class DeleteContact extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Contact contact = new Contact();
        try {
            AppDao dao = AppDaoFactory.getAppDao();
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("user");
            contact.setId(Integer.parseInt(request.getParameter("id")));
            contact.setUserId(user.getId());
            dao.deleteContact(contact, user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.sendRedirect("home");

        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher view;
        view = request.getRequestDispatcher("pages/home.jsp");
        view.forward(request, response);
    }

}