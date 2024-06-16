package org.zerock.w06.service;

import org.zerock.w06.dto.BoardDTO;
import org.zerock.w06.dto.PageRequestDTO;
import org.zerock.w06.dto.PageResponseDTO;

public interface BoardService {

    Long register(BoardDTO boardDTO);

    BoardDTO readOne(Long bno);

    void modify(BoardDTO boardDTO);

    void remove(Long bno);

    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);

}
