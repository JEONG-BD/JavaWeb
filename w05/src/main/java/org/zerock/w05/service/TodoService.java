package org.zerock.w05.service;

import jdk.vm.ci.meta.Local;
import org.zerock.w05.dto.PageRequestDTO;
import org.zerock.w05.dto.PageResponseDTO;
import org.zerock.w05.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    void register(TodoDTO todoDTO);

    //List<TodoDTO> getAll();

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);

    void delete(Long tno);

    void update(TodoDTO todoDTO);
}
