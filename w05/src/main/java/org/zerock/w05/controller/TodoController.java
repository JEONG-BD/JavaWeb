package org.zerock.w05.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.w05.dto.TodoDTO;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {
    
    @RequestMapping("/list")
    public void list(){
        log.info("Get List...");
    }

    //@RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public void registerGet() {
        log.info("Get register...");

    }

    //@RequestMapping(value = "/register", method = RequestMethod.GET)
    @PostMapping("/register")
    public void registerPost(TodoDTO todoDTO) {
        log.info("Post register...");
        log.info(todoDTO);
    }




}
