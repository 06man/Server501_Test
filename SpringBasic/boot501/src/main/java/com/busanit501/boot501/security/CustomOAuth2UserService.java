package com.busanit501.boot501.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    // 소셜 로그인시, 반환 타입 : OAuth2User
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("kakao login CustomOAuth2UserService userRequest");
        log.info(userRequest);

        // userRequest: 소셜 유저의 정보 담겨 있음.
        // 이메일 추출 해보기.
        ClientRegistration clientRegistration
                = userRequest.getClientRegistration();
        String clientName = clientRegistration.getClientName();
        log.info("clientName : " + clientName);

        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> paramMap = oAuth2User.getAttributes();
        //paramMap
        //키: properties, 값 : 객체 안에(맵구조), nickname=이상용
        //키: properties, 값 : 객체 안에(맵구조), profile_image=http://k.kakaocdn.net/dn/IbxaJ/btsJ3hcSYmJ/6zalcIKKnKf3gJNqEusBo0/img_640x640.jpg
        //키: kakao_account, 값 : 객체 안에(맵구조), email=lsy3709@kakao.com

        // 소셜 정보 출력 확인용
        paramMap.forEach((key, value) -> {
            log.info("key : " + key + " value : " + value);
        });

        String email = null;

        switch (clientName) {
            case "kakao":
                //getKakaoEmail(paramMap) , 메서드를 밑에 정의
                email = getKakaoEmail(paramMap);
                break;
        }

        return oAuth2User;
    }

    private String getKakaoEmail(Map<String, Object> params) {
        Object value = params.get("kakao_account");
        LinkedHashMap accountMap = (LinkedHashMap) value;
        String email = (String) accountMap.get("email");
        log.info("email : " + email);
        return email;
    }

}
