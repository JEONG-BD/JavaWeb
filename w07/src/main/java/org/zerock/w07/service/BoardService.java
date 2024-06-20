package org.zerock.w07.service;

import org.zerock.w07.dto.BoardDTO;
import org.zerock.w07.dto.BoardListReplyCountDTO;
import org.zerock.w07.dto.PageRequestDTO;
import org.zerock.w07.dto.PageResponseDTO;

public interface BoardService {
    Long register(BoardDTO boardDTO);

    BoardDTO readOne(Long bno);

    void modify(BoardDTO boardDTO);

    void delete(Long bno);

    PageResponseDTO<BoardDTO> list (PageRequestDTO pageRequestDTO);

    PageResponseDTO<BoardListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO);
}
