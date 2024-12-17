package com.busanit501.boot501.repository;

import com.busanit501.boot501.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
    // 기본적인 crud , 쿼리 스트링으로 가능함.
}
