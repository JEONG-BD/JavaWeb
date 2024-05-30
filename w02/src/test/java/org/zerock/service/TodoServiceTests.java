package org.zerock.service;

import com.zerock.w02.dao.TodoDAO;
import com.zerock.w02.dto.TodoDTO;
import com.zerock.w02.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TodoServiceTests {

    private TodoService todoService;

    @BeforeEach
    public void ready(){
        todoService =  TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {

        TodoDTO todoDTO = TodoDTO.builder()
                .title("JDBC Test Title")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();

        todoService.register(todoDTO);
    }
}
