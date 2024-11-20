package com.busanit501.helloworld;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// 서블릿 파일
// 자바 파일. -> 컴파일 class -> 서버가 로드 메모리 올려서 사용함.
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    // 라이프 사이클, 생명주기.
    // 객체의 생명주기, 나중에, 프론트 앞단에서, 컴포넌트의 생명주기.
    // 객체 생성 후, 소멸 하는 과정.

    // 서버가 시작시, 최초로 한번 실행.
    public void init() {
        message = "Hello World!";
    }

    //  get 호출시 마다, 메서드가 호출.
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    // 서버가 종료시, 해당 객체를 반납하는 역할.
    public void destroy() {
    }
}