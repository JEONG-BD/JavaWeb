package org.zerock.w06.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.w06.domain.Board;

public interface BoardSearch {

    Page<Board> search1(Pageable pageable);
}
