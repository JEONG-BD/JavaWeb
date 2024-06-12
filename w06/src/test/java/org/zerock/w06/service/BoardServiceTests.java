package org.zerock.w06.service;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.w06.dto.BoardDTO;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private  BoardService boardService;

    @Test
    public void testRegister(){
        log.info(boardService.getClass().getName());

        BoardDTO boardDTO = BoardDTO.builder()
                .title("Sample Test")
                .content("Sample Content")
                .writer("Sample Writer")
                .build();

        Long bno = boardService.register(boardDTO);

        log.info("bno" + bno);

    }

    @Test
    public void testModify(){
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(101L)
                .title("Update 101L")
                .content("Update 101L")
                .build();

        boardService.modify(boardDTO);
    }

    @Test
    public void testRemove(){
        boardService.remove(1L);
    }
}
