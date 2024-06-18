package org.zerock.w07.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@Tag(name = "예제 API", description = "Swagger Test API")
public class SampleController {

    @Operation(summary = "Test", description = "Test")
    @GetMapping("/hello")
    public void hello(Model model){
        log.info("hello");
        model.addAttribute("msg", "hello world");
    }
}
