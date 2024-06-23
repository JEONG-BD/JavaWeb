package org.zerock.w07.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.w07.dto.ReplyDTO;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/replies")
@Log4j2
@Tag(name = "Reply API", description = "Swagger Reply API")
public class ReplyController  {

    @Operation(summary = "Replies POST", description = "reply register")
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> register(@Valid @RequestBody ReplyDTO replyDTO,
                                      BindingResult bindingResult) throws BindException {
        log.info("========");
        log.info(replyDTO);
        log.info("========");

        if (bindingResult.hasErrors()){

            System.out.println("Error");
            System.out.println("Error");
            System.out.println("Error");
            System.out.println("Error");

            throw new BindException(bindingResult);
        }
        System.out.println("-----");
        System.out.println("-----");
        System.out.println("-----");
        System.out.println("-----");

        Map<String, Long> resultMap = new HashMap<>();
        log.info(resultMap);
        log.info(resultMap);
        resultMap.put("rno", 111L);

        return resultMap;
        // return ResponseEntity.ok(resultMap);


    }


}