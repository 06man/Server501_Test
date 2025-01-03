package com.busanit501.boot501.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

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

        paramMap.forEach((key, value) -> {
            log.info("key : " + key + " value : " + value);
        });

        return oAuth2User;
    }
}
