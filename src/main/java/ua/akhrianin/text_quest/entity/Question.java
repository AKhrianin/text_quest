package ua.akhrianin.text_quest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Question {
    private int id;
    private String text;
    private Type type;

    public enum Type {
        CONTINUE,
        END,
        SUCCESS
    }
}
