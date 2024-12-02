package com.busanit501.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
