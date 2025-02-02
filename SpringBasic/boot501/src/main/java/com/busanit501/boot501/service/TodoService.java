package com.busanit501.boot501.service;

import com.busanit501.boot501.dto.TodoDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TodoService {
    Long register(TodoDTO todoDTO);
}
