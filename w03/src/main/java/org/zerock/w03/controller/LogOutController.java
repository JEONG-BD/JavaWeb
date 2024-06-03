package org.zerock.w03.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
@Log4j2
public class LogOutController extends HttpServlet {

    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("log Out...");

        HttpSession session = req.getSession();

        session.removeAttribute("loginInfo");
        session.invalidate();

        res.sendRedirect("/");

    }

}
