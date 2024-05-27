package org.zerock.w00.calc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calaController", urlPatterns = "/calc/makeResult")
public class CalcController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        System.out.printf("num 1 : %s" ,num1);
        System.out.printf("num 2 : %s" ,num2);

        res.sendRedirect("/index");
    }


}
