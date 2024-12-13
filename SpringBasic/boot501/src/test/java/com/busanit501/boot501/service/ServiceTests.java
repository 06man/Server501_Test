package com.busanit501.boot501.service;

import com.busanit501.boot501.dto.BoardDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
public class ServiceTests {
    @Autowired
    private BoardService boardService;

    @Test
    public void testRegisterBoard() {
        // 더미 데이터 필요, 임시 DTO 생성.
        BoardDTO boardDTO = BoardDTO.builder()
                .title("오늘 점심 뭐 먹지?")
                .content("라면 먹어야지")
                .writer("이상용")
                .regDate(LocalDateTime.now())
                .build();

        Long bno = boardService.register(boardDTO);
        log.info("입력한 게시글 번호: " + bno.toString());
    }

    @Test
    public void testSelectOneBoard() {
        // 더미 데이터 필요, 임시 DTO 생성.
        Long bno = 103L;
        BoardDTO boardDTO= boardService.readOne(bno);
        log.info("testSelectOneBoard , 하나 조회 boardDTO: " + boardDTO.toString());
    }

    @Test
    public void testUpdateBoard() {
        // 수정할 더미 데이터 필요,
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(103L)
                .title("수정한 오늘 점심 뭐 먹지?")
                .content("칼국수 먹을까?")
                .build();
        boardService.update(boardDTO);

    }
}
