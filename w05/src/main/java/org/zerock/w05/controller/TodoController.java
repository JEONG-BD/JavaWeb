package org.zerock.w05.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.w05.dto.PageRequestDTO;
import org.zerock.w05.dto.PageResponseDTO;
import org.zerock.w05.dto.TodoDTO;
import org.zerock.w05.service.TodoService;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@RequiredArgsConstructor
@Log4j2
public class TodoController {


    private final TodoService todoService;

/*
    @RequestMapping("/list")
    public void list(Model model){

        log.info("Get List...");

        model.addAttribute("dtoList", todoService.getAll());
    }
*/

    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model){

        log.info(pageRequestDTO);

        if(bindingResult.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
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

        todoService.register(todoDTO);


        return "redirect:/todo/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long tno, PageRequestDTO pageRequestDTO, Model model) {
        log.info("Get read...");

        TodoDTO todoDTO = todoService.getOne(tno);

        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);
    }

    @PostMapping("/remove")
    public String remove(Long tno,
                         PageRequestDTO pageRequestDTO,
                         RedirectAttributes redirectAttributes) {

        log.info("Post remove");
        log.info("tno" + tno);

        todoService.delete(tno);
        log.info("-----------");
        log.info(pageRequestDTO);
        log.info("-----------");

        redirectAttributes.addAttribute("page", 1);
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
        return "redirect:/todo/list";
    }

    @PostMapping("/modify")
    public String update(@Valid TodoDTO todoDTO,
                         PageRequestDTO pageRequestDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        log.info("Post modify");

        if(bindingResult.hasErrors()){
            log.info("Post Modify error");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            redirectAttributes.addAttribute("tno", todoDTO.getTno());

            return "redirect:/todo/modify";
        }

        log.info(todoDTO);

        todoService.update(todoDTO);

        //redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        //redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
        redirectAttributes.addAttribute("tno", todoDTO.getTno());
        return "redirect:/todo/read";
    }
}
