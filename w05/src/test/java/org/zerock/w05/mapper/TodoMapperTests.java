package org.zerock.w05.mapper;

import com.sun.tools.javac.comp.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.w05.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testGetTime() {
        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert(){
        TodoVO todoVO = TodoVO.builder()
                .title("Spring Test2")
                .dueDate(LocalDate.of(2024,6,5))
                .writer("user00")
                .build();

        todoMapper.insert(todoVO);
    }

    @Test
    public void testSelectAll(){

        List<TodoVO> voList = todoMapper.selectAll();

        voList.forEach(vo -> log.info(vo));

    }

    @Test
    public void testSelectOne(){

        TodoVO todoVO = todoMapper.selectOne(1L);

        log.info(todoVO);
    }

    @Test
    public void testDelete(){
        todoMapper.delete(1L);
    }

}
