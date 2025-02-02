package com.busanit501.boot501.service;

import com.busanit501.boot501.domain.Todo;
import com.busanit501.boot501.dto.TodoDTO;
import com.busanit501.boot501.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;

    @Override
    public Long register(TodoDTO todoDTO) {
        Todo todo = modelMapper.map(todoDTO, Todo.class);
        Long tno = todoRepository.save(todo).getTno();
        return tno;
    }

    //    @Override
//    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {
//        Page<TodoDTO> result = todoRepository.list(pageRequestDTO);
//        return PageResponseDTO.<TodoDTO>withAll().pageRequestDTO(pageRequestDTO).dtoList(result.toList()).total((int) result.getTotalElements()).build();
//    }
//    @Override
//    public void remove(Long tno) {
//        todoRepository.deleteById(tno);
//    }
//
//    @Override
//    public void modify(TodoDTO todoDTO) {
//        Optional<Todo> result = todoRepository.findById(todoDTO.getTno());
//        Todo todo = result.orElseThrow();
//        todo.changeTitle(todoDTO.getTitle());
//        todo.changeDueDate(todoDTO.getDueDate());
//        todo.changeComplete(todoDTO.isComplete());
//        todoRepository.save(todo);
//    }
}
