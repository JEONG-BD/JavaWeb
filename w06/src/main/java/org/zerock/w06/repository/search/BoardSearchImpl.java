package org.zerock.w06.repository.search;

import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.w06.domain.Board;
import org.zerock.w06.domain.QBoard;

import java.util.List;

;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl(){
        super(Board.class);
    }

    @Override
    public Page<Board> search1(Pageable pageable) {

        QBoard board = QBoard.board;

        JPQLQuery<Board> query = from(board);

//        BooleanBuilder booleanBuilder = new BooleanBuilder(); // (
//
//        booleanBuilder.or(board.title.contains("11")); // title like ...
//
//        booleanBuilder.or(board.content.contains("11")); // content like ....
//
//        query.where(booleanBuilder);
//        query.where(board.bno.gt(0L));
//
//
//        //paging
//        this.getQuerydsl().applyPagination(pageable, query);
//
//        List<Board> list = query.fetch();
//
//        long count = query.fetchCount();

        query.where(board.title.contains("1"));
        return null;

    }

}
