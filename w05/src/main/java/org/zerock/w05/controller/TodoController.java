package org.zerock.w05.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.w05.dto.TodoDTO;

import javax.validation.Valid;

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
    public String registerPost(@Valid TodoDTO todoDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("Post register...");

        if (bindingResult.hasErrors()) {
            log.info("has Error...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/todo/register";
        }
        log.info(todoDTO);



        return "redirect:/todo/list";
    }




}
