package com.busanit501.boot501.repository.search;

import com.busanit501.boot501.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

// 반드시 이름 작성시: 인터페이스이름 + Impl
// QuerydslRepositorySupport 의무 상속,
// 만든 인터페이스 구현하기.
public class BoardSearchImpl extends QuerydslRepositorySupport
implements BoardSearch {


    // 부모 클래스 초기화, 사용하는 엔티티 클래스를 설정.
    // Board
    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search(Pageable pageable) {
        return null;
    }
}
