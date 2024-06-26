package org.zerock.w07.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.w07.domain.Board;
import org.zerock.w07.dto.BoardDTO;
import org.zerock.w07.dto.BoardListReplyCountDTO;

public interface BoardSearch {

    Page<Board> search1(Pageable pageable);

    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);

    Page<BoardListReplyCountDTO> searchWithReplyCount(String[]types, String keyword, Pageable pageable);


}
