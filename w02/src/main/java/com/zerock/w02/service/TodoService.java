package com.zerock.w02.service;

import com.zerock.w02.dao.TodoDAO;
import com.zerock.w02.domain.TodoVO;
import com.zerock.w02.dto.TodoDTO;
import com.zerock.w02.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum TodoService {
    INSTANCE ;

    private TodoDAO dao ;
    private ModelMapper modelMapper;

    TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        // System.out.println("todoVO" + todoVO);
        log.info(todoVO);

        dao.insert(todoVO);
    }

}
