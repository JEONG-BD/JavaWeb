package org.zerock.w08.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class SampleController {

    @Operation(summary = "test", description = "test")
    @GetMapping("/test")
    public void hello(Model model){
        log.info("hello");
        model.addAttribute("hello", "world");
    }

}
