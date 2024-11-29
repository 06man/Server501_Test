package com.busanit501.springex.sample;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 컨트롤러 역할 , @Controller
// 서비스 역할 , @Service
// DAO 역할, @Repository
@Component // 일반 객체 타입을 시스템 등록,
@ToString
public class SampleService {
    @Autowired
    private SampleDAO sampleDAO;

}
