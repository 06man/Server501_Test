package com.busanit501.boot501.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        //상태 코드 가져오기.
        int statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == 403) {
            return "error/403";
        } else if (statusCode == 404) {
            return "error/404";
        }
        return "error/500";
    }
}
