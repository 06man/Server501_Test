package com.busanit501.boot501.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity // JPA 이용해서, 엔티티 클래스 , 데이터베이스 테이블 만들기 놀이.
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString //로그를 해당 인스턴스 찍을 때, 해당 멤버를 쉽게 확인 가능.
public class Board extends BaseEntity { // 전역으로 만든, 베이스 엔티티 클래스  적용.

    //2 번째 작업, 제약조건 넣기, 각 멤버는 각 디비의 컬럼과 동일함,
    // 그래서,각각에 제약조건 설정하기.

    @Id // PK, 기본키,
    // Oracle, 시퀸스 객체, 이용시, SEQUENCE 설정, 추가 설정. 필요함.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 마리아디비,
    private Long bno;

    //제약조건 넣기
    @Column(length = 500, nullable = false)// 길이 500자,  NotNull=nn
    private String title;

    @Column(length = 2000, nullable = false)// 길이 500자,  NotNull=nn
    private String content;

    @Column(length = 50, nullable = false)// 길이 500자,  NotNull=nn
    private String writer;
    // 모든 테이블에 공통으로 들어갈수 있는, 등록시간, 수정시간, 등,
    // 베이스 엔티티에서 작업 할 예정.
}
