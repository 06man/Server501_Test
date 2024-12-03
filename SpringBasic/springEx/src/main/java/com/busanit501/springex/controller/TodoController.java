package com.busanit501.springex.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller// 1)화면 2)데이터 제공.
@RequestMapping("/todo")
// 웹브라우저에서 아래의 경로로 오는 url 전부 여기 컨트롤러가 받아서 작업함.
// localhost:8080/todo/
@Log4j2
public class TodoController {

    @RequestMapping("/list")
    public void list() {
        log.info("TodoController list : 화면제공은 해당 메서드 명으로 제공함.");
    }
}








