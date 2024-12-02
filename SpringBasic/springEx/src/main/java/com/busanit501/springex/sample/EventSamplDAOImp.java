package com.busanit501.springex.sample;

import org.springframework.stereotype.Repository;

// 문제점, SampleDAO , 인터페이스를 구현하는 클래스가 2개인데,
// 시스템에게 2개를 알려줌, -> 시스템 입장에서, 어느 것을 선택 해야하는 문제점.

@Repository
public class EventSamplDAOImp implements SampleDAO{

}
