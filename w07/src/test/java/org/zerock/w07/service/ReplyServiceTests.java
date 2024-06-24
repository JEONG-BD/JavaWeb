package org.zerock.w07.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.w07.dto.ReplyDTO;

@SpringBootTest
@Log4j2
public class ReplyServiceTests {


    @Autowired
    private ReplyService replyService;

    @Test
    public void testRegister() {

        ReplyDTO replyDTO = ReplyDTO.builder()
                .replyText("Reply Test")
                .replyer("Test user")
                .bno(108L)
                .build();
        log.info("===================");
        log.info(replyService.register(replyDTO));
        log.info("===================");

    }
}
