package com.busanit501.boot501.repository.search;

import com.busanit501.boot501.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// Querydsl 이용시, 해당 인터페이스에서, Jq
public interface BoardSearch {
    Page<Board> search(Pageable pageable);
}
