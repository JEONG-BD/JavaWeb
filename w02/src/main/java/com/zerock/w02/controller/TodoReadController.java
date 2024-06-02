package com.zerock.w02.controller;


import com.zerock.w02.dto.TodoDTO;
import com.zerock.w02.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", value="/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {

    TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            Long tno = Long.parseLong(req.getParameter("tno"));

            TodoDTO todoDTO = todoService.get(tno);

            req.setAttribute("dto", todoDTO);

            req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, res);


        } catch (Exception e){
            log.error(e.getMessage());
            throw  new ServletException("read error");
        }
    }
}
