package org.zerock.w06.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.w06.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
