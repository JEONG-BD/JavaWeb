package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.w03.dao.TodoDAO;
import org.zerock.w03.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoTests {

    private TodoDAO todoDAO ;

    @BeforeEach
    public void ready(){
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testInsert() throws  Exception {
        TodoVO todoVO = TodoVO.builder()
                .title("W03 Test...")
                .dueDate(LocalDate.of(2024, 06, 03))
                .build();

        todoDAO.insert(todoVO);
    }

    @Test
    public void testList() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();

        list.forEach(vo -> System.out.println(vo));
    }
}
