package com.busanit501.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

// 1) 화면제공 2) 데이터제공
@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    // 확인. http://localhost:8080/hello
    // 맵핑, 메서드명과 동일한 뷰 파일로 연결.
    // /WEB-INF/views/
    //  hello(메서드명)
     // .jsp
    public void hello() {
        // 아직 화면이 없어서, 임의로 만들기.
        log.info("hello");
    }

    @GetMapping("/hello2")
    // 만약에 리턴 타입이 문자열이면, 해당 문자열의 이름이
    // 뷰의 파일명으로 , 뷰를 맵핑, 할당.
      public String hello2() {
        // 아직 화면이 없어서, 임의로 만들기.
        log.info("hello2");
        return "helloTest";
    }

    @GetMapping("/ex1")
    // 파라미터 수집 여부만 확인, 뷰없이, 콘솔에서 확인.
    // localhost:8080/ex1?name=lsy&age=41
    public void ex1(String name, int age) {
        log.info("ex1 name:" + name);
        log.info("ex1 age:" + age);

    }

    @GetMapping("/ex2")
    // 파라미터 수집 여부만 확인, 뷰없이, 콘솔에서 확인.
    // localhost:8080/ex2?name=lsy&age=41
    public void ex2(@RequestParam(name = "name", defaultValue = "LSY") String name,
                    @RequestParam(name = "age", defaultValue = "30")int age) {
        log.info("ex2 name:" + name);
        log.info("ex2 age:" + age);
    }

    @GetMapping("/ex3")
    // 웹브라우저에서 넘어온 데이터 타입은 문자열이어서,
    // 받을 때 타입 불일치 오류 확인.
    // localhost:8080/ex3?dueDate=2024-12-03
    // 대책은, 미리, 형이 다른 문자열에 대해서,
    // LocalDate <-> String  , 미리 만들어두기.
    //
    // 시스템에 , 빈으로 등록해서,
    // LocalDate가 문자열로 전송되어도, 시스템이 자동으로  LocalDate 형 변환해줌.
    public void ex3(LocalDate dueDate) {
        log.info("ex3 dueDate:" + dueDate);
    }

}
