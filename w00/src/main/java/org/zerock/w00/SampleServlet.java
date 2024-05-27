package org.zerock.w00;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpRetryException;

@WebServlet(name = "sampleServlet", urlPatterns = "/sample")
public class SampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws HttpRetryException, IOException {

        System.out.println("doGet Method..." + this);

    }

    @Override
    public void destroy() {
        System.out.println("doDestroy...");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init(ServlefConfig)...");
    }

}
