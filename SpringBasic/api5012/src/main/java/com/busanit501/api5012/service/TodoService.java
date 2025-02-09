package com.busanit501.api5012.service;

import com.busanit501.api5012.dto.PageRequestDTO;
import com.busanit501.api5012.dto.PageResponseDTO;
import com.busanit501.api5012.dto.PageResponseDTO2;
import com.busanit501.api5012.dto.TodoDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TodoService {
    Long register(TodoDTO todoDTO);
    TodoDTO read(Long tno);
    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);
    PageResponseDTO2<TodoDTO> list2(int size, Long cursor);
    Long getMaxTno();
    void remove(Long tno);
    void modify(TodoDTO todoDTO);
}
