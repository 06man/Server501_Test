package com.busanit501.boot501.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyDTO {
    private Long rno;
    private Long bno;
    private String replyText;
    private String replyer;
    private LocalDateTime regDate,modDate;
}
