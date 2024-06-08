package org.zerock.w05.mapper;

import org.zerock.w05.domain.TodoVO;
import java.util.List;
public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();
}
