package ua.akhrianin.text_quest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Answer {
    private int id;
    private String text;
    private int currentQuestionId;
    private int nextQuestionId;
}