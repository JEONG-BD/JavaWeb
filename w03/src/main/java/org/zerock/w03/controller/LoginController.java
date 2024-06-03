package org.zerock.w03.controller;


import lombok.extern.java.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
@Log
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        log.info("login Get...");

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, res);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {

        log.info("login Post...");

        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        String str =mid + mpw ;

        HttpSession session = req.getSession();

        session.setAttribute("loginfo", str);

        res.sendRedirect("/todo/list");
    }


}
