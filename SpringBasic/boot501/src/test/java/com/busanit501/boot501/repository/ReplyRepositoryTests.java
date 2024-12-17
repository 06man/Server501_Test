package com.busanit501.boot501.repository;

import com.busanit501.boot501.domain.Board;
import com.busanit501.boot501.domain.Reply;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void testInsert() {
        // 댓글을 작성 하려면, 부모 게시글 번호가 필요,
        // 각자 데이터베이스에 따라서, 다르므로 꼭 확인하고, 작업.
        Long bno = 121L;

        Board board = Board.builder().bno(bno).build();

        Reply reply = Reply.builder()
                .board(board)
                .replyText("샘플 댓글")
                .replyer("샘플 작성자")
                .build();

        replyRepository.save(reply);
    }

    @Transactional
    @Test
    public void testSelect() {
        Long bno = 121L;
        // 페이징 조건, 준비물 준비
        Pageable pageable = PageRequest.of(0,10, Sort.by("rno").descending());

        //
        Page<Reply> result = replyRepository.listOfBoard(bno, pageable);
        // result 안에, 페이징 조건의 준비물이 다 있음.
        // 1) 전체 갯수, 2) 페이지 3) 페이지당 크기 4) 페이징 처리된 목록 요소
        result.getContent().forEach(reply -> {
            log.info(reply);
        });
    }
}






