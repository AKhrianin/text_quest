package ua.akhrianin.text_quest.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    int gameCount;
    String username;
}
