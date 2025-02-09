package com.busanit501.api5012.service;

import com.busanit501.api5012.dto.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TodoService {
    Long register(TodoDTO todoDTO);
    TodoDTO read(Long tno);
    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);
    PageResponseDTO2<TodoDTO> list2(PageRequestDTO2 pageRequestDTO);
    Long getMaxTno();
    void remove(Long tno);
    void modify(TodoDTO todoDTO);
}
