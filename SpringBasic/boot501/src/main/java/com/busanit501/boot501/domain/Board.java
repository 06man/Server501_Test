package com.busanit501.boot501.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // JPA 이용해서, 엔티티 클래스 , 데이터베이스 테이블 만들기 놀이.
public class Board {
    @Id // PK, 기본키,
    // Oracle, 시퀸스 객체, 이용시, SEQUENCE 설정, 추가 설정. 필요함.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 마리아디비,
    private Long bno;

    private String title;
    private String content;
    private String writer;
    // 모든 테이블에 공통으로 들어갈수 있는, 등록시간, 수정시간, 등,
    // 베이스 엔티티에서 작업 할 예정.
}
