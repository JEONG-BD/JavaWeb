package org.zerock.w07.service;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.w07.dto.BoardDTO;
import org.zerock.w07.dto.PageRequestDTO;
import org.zerock.w07.dto.PageResponseDTO;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private BoardService boardService ;

    @Test
    public void testRegister(){
        log.info(boardService.getClass().getName());

        BoardDTO boardDTO = BoardDTO.builder()
                .title("Sample title")
                .content("Sample content")
                .writer("user0000")
                .build();

        Long bno = boardService.register(boardDTO);
        log.info("bno" + bno);
    }

    @Test
    public void testReadOne(){
        Long bno = 11L;

    }

    @Test
    public void testModify(){
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(103L)
                .title("xpxpxpxp")
                .content("adadad")
                .build();
        boardService.modify(boardDTO);
    }

    @Test
    public void testDelete(){
        Long bno = 104L;

        boardService.delete(bno);
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tct")
                .keyword("1")
                .page(1)
                .size(10)
                .build();

        PageResponseDTO responseDTO = boardService.list(pageRequestDTO);

        log.info(responseDTO);
    }
}
