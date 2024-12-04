package com.busanit501.springex.mapper;

import com.busanit501.springex.domain.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class) //JUnit5 테스트 설정.
//JUnit4 테스트 설정. @Runwith
// 설정 파일의 경로를 지정.
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTest {

    // 해당 인스턴스가 없다면, 널로 받을게.
    // 기본값은 required = true
    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testGetTime() {
        log.info("getTime : " + todoMapper.getTime());
    }

    @Test
    public void testInsert() {
        // 더미 데이터 , TodoVO 담아서, 진행.
        TodoVO todoVO = TodoVO.builder()
                .title("샘플 테스트")
                .dueDate(LocalDate.now())
                .writer("이상용")
                .build();
        todoMapper.insert(todoVO);
    }

    @Test
    public void testSelectAll() {
        List<TodoVO> lists = todoMapper.selectAll();
        for (TodoVO todoVo:lists) {
            log.info("todoVo : " + todoVo);
        }
    }

    @Test
    public void testSelectOne() {
        TodoVO  todoVo = todoMapper.selectOne(9L);
            log.info("todoVo : " + todoVo);
    }

}
