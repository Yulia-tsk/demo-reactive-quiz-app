package com.reactivespring.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;



@Data

public class Question {
    @Id
    private long id;

    private String text;

    private String correctAnswer;

    private String topic;
}
