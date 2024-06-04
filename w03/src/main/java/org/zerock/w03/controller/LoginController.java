package org.zerock.w03.controller;


import lombok.extern.java.Log;
import org.zerock.w03.dto.MemberDTO;
import org.zerock.w03.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

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

        String auto = req.getParameter("auto");

        boolean remberMe = auto != null && auto.equals("on");


        //String str =mid + mpw ;
        try {

            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);

            if (remberMe) {
                String uuid = UUID.randomUUID().toString();
                MemberService.INSTANCE.updateUuid(mid, uuid);
                memberDTO.setUuid(uuid);

                Cookie remberCookie = new Cookie("rember-me", uuid);
                remberCookie.setMaxAge(60 * 60 * 24 * 7);
                remberCookie.setPath("/");

                res.addCookie(remberCookie);
            }
            HttpSession session = req.getSession();

            session.setAttribute("loginInfo", memberDTO);

            res.sendRedirect("/todo/list");
        } catch (Exception e) {
            res.sendRedirect("/login?result=error");
        }
    }
}
