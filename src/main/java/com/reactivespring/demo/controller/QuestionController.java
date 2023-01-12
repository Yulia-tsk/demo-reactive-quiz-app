package com.reactivespring.demo.controller;

import com.reactivespring.demo.model.Question;
import com.reactivespring.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Question> getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Mono<Question> getById(@PathVariable long id){
        return questionService.getQuestionById(id);
    }

    @PostMapping
    public Mono<Question> createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @PutMapping("/{id}")
    public Mono<Question> updateQuestion(@RequestBody Question question, @PathVariable long id){
        return questionService.updateQuestion(question, id);
    }
}
