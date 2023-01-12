package com.reactivespring.demo.repository;

import com.reactivespring.demo.model.Question;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface QuestionRespository extends ReactiveCrudRepository<Question, Long> {
}
