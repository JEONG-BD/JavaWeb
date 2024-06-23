package org.zerock.w07.service;

import org.zerock.w07.dto.PageRequestDTO;
import org.zerock.w07.dto.PageResponseDTO;
import org.zerock.w07.dto.ReplyDTO;

public interface ReplyService {

    Long register(ReplyDTO replyDTO);

    ReplyDTO read(Long rno);

    void modify(ReplyDTO replyDTO);

    void remove(Long rno);

    PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO);
}
