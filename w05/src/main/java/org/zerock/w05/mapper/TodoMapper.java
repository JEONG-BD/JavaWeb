package org.zerock.w05.mapper;

import org.zerock.w05.domain.TodoVO;
import java.util.List;
public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO todoVO);
}
