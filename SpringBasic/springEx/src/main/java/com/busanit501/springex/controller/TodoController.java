package com.busanit501.springex.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller// 1)화면 2)데이터 제공.
@RequestMapping("/todo")
// 웹브라우저에서 아래의 경로로 오는 url 전부 여기 컨트롤러가 받아서 작업함.
// localhost:8080/todo/
@Log4j2
public class TodoController {

    // localhost:8080/todo/list
    @RequestMapping("/list")
    public void list() {
        log.info("TodoController list : 화면제공은 해당 메서드 명으로 제공함.");
    }

    // localhost:8080/todo/register
    // 1) 글작성 폼, 화면 -> get
    // 2) 글작성 로직 처리 -> post
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register() {
        log.info("TodoController register : 화면제공은 해당 메서드 명으로 제공함.");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void registerPost() {
        log.info("TodoController register post 로직처리: ");
    }
}








