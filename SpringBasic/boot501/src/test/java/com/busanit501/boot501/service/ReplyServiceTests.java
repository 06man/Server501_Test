package com.busanit501.boot501.service;

import com.busanit501.boot501.dto.ReplyDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
public class ReplyServiceTests {
    @Autowired
    private ReplyService replyService;

    @Test
    @Transactional
    public void testRegisterReply() {
        // 더미 데이터 필요, 임시 DTO 생성.
        ReplyDTO replyDTO = ReplyDTO.builder()
                .replyText("오늘 점심 뭐 먹지?")
                .replyer("이상용")
                .bno(122L)
                .regDate(LocalDateTime.now())
                .build();

        // register 함수 호출 전에도,  bno 존재
        log.info("replyDTO , register 함수 호출 하기전 : "+replyDTO);
        Long bno = replyService.register(replyDTO);
        log.info("입력한 댓글 번호: " + bno.toString());
    }
}
