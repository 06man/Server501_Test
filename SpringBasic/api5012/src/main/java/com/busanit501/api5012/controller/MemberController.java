package com.busanit501.api5012.controller;


import com.busanit501.api5012.domain.APIUser;
import com.busanit501.api5012.dto.APIUserDTO;
import com.busanit501.api5012.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Log4j2
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody APIUser apiUser) {
        log.info("apiUser확인" + apiUser);
        memberService.joinMember(apiUser);
        return ResponseEntity.ok("회원가입 성공");
    }
}