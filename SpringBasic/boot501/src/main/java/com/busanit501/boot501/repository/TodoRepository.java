package com.busanit501.boot501.repository;

import com.busanit501.boot501.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> { }
