package com.busanit501.boot501.repository.search;

import com.busanit501.boot501.dto.PageRequestDTO;
import com.busanit501.boot501.dto.TodoDTO;
import org.springframework.data.domain.Page;

public interface TodoSearch {
    Page<TodoDTO> list(PageRequestDTO pageRequestDTO);
}
