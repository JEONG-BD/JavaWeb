package org.zerock.dao;

import com.zerock.w02.dao.TodoDAO;
import com.zerock.w02.domain.TodoVO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready(){
      todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title")
                .dueDate(LocalDate.of(2024, 12, 31))
                .build();

        todoDAO.insert(todoVO);

    }

    @Test
    public void testList() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();

        list.forEach(System.out::println);

    }

    @Test
    public void testSelectOne() throws Exception {
        Long tno = 1L;

        TodoVO vo = todoDAO.selectOne(tno);

        System.out.println(vo);
    }

    @Test
    public void testUpdateOne() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .tno(1L)
                .title("Update Test")
                .dueDate(LocalDate.of(2024, 12, 30))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);
    }
}
