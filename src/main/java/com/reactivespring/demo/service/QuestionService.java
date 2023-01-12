package com.reactivespring.demo.service;

import com.reactivespring.demo.repository.QuestionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reactivespring.demo.model.Question;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class QuestionService {

    @Autowired
    private QuestionRespository questionRespository;

    public Flux<Question> getAllQuestions(){

        return questionRespository.findAll()
                .delayElements(Duration.ofSeconds(5));
    }

    public Mono<Question> getQuestionById(long id) {

        return questionRespository.findById(id);
    }

    public Mono<Question> createQuestion(Question question){
        return questionRespository.save(question);
    }

    public Mono<Question> updateQuestion(Question question, long id) {
        return questionRespository.findById(id)
                .map((q) ->{
                    q.setText(question.getText());
                    return q;
                }).flatMap(q -> questionRespository.save(q));
    }
}
