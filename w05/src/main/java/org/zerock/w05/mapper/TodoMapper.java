package org.zerock.w05.mapper;

import org.zerock.w05.domain.TodoVO;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);
}
