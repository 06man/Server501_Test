package com.busanit501.helloworld.jdbcex;

import com.busanit501.helloworld.jdbcex.dao.MemberDAO;
import com.busanit501.helloworld.jdbcex.vo.MemberVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class MemberDAOTest {
    private MemberDAO memberDAO;

    // 아래에 각 단위 테스트가 실행되기전에, 먼저 실행을 함.
    @BeforeEach
    public void ready() {
        memberDAO = new MemberDAO();
    }

    @Test
    public void getMemberWithMpwTest() throws SQLException {
        String mid = "lsy";
        String mpw = "1234";
       MemberVO memberVO = memberDAO.getMemberWithMpw(mid,mpw);
    }

}
