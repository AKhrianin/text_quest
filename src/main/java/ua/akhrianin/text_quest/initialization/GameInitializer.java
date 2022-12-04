package ua.akhrianin.text_quest.initialization;

import ua.akhrianin.text_quest.entity.Answer;
import ua.akhrianin.text_quest.entity.Question;

import java.util.ArrayList;
import java.util.List;

public class GameInitializer {

    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(
                Question.builder()
                        .id(1)
                        .type(Question.Type.CONTINUE)
                        .text("Необходимо решить, что делать дальше, вы голодны и замерзаете")
                        .build()
        );

        questions.add(
                Question.builder()
                        .id(2)
                        .type(Question.Type.CONTINUE)
                        .text("Вы находите старый фонарь, похоже, заряд еще сохранился, у дальней стены вы замечаете два прохода")
                        .build()
        );

        questions.add(
                Question.builder()
                        .id(3)
                        .type(Question.Type.END)
                        .text("Вы умерли от голода. Это конец.")
                        .build()
        );

        questions.add(
                Question.builder()
                        .id(4)
                        .type(Question.Type.CONTINUE)
                        .text("Вы вышли к пещерному озеру.")
                        .build()
        );

        questions.add(
                Question.builder()
                        .id(5)
                        .type(Question.Type.CONTINUE)
                        .text("Вы вышли к старой стоянке неизвестных людей.")
                        .build()
        );

        questions.add(
                Question.builder()
                        .id(6)
                        .type(Question.Type.END)
                        .text("Вода отравлена, вы теряете сознание. Это конец.")
                        .build()
        );

        questions.add(
                Question.builder()
                        .id(7)
                        .type(Question.Type.END)
                        .text("Консервы оказались слишком старыми, вы теряете сознание. Это конец.")
                        .build()
        );

        questions.add(
                Question.builder()
                        .id(8)
                        .type(Question.Type.SUCCESS)
                        .text("Вы видите свет и выходите из пещеры навстречу новым приключениям. Это успех.")
                        .build()
        );

        return questions;
    }

    public List<Answer> getAnswers() {
        List<Answer> answers = new ArrayList<>();

        answers.add(
                Answer.builder()
                        .currentQuestionId(1)
                        .nextQuestionId(2)
                        .id(1)
                        .text("Осмотреться.")
                        .build()
        );

        answers.add(
                Answer.builder()
                        .currentQuestionId(1)
                        .nextQuestionId(3)
                        .id(2)
                        .text("Ничего не делать.")
                        .build()
        );

        answers.add(
                Answer.builder()
                        .currentQuestionId(2)
                        .nextQuestionId(4)
                        .id(3)
                        .text("Пойти вправо.")
                        .build()
        );

        answers.add(
                Answer.builder()
                        .currentQuestionId(2)
                        .nextQuestionId(5)
                        .id(4)
                        .text("Пойти влево.")
                        .build()
        );

        answers.add(
                Answer.builder()
                        .currentQuestionId(4)
                        .nextQuestionId(6)
                        .id(5)
                        .text("Подойти и выпить воду.")
                        .build()
        );

        answers.add(
                Answer.builder()
                        .currentQuestionId(4)
                        .nextQuestionId(8)
                        .id(6)
                        .text("Идти дальше.")
                        .build()
        );

        answers.add(
                Answer.builder()
                        .currentQuestionId(5)
                        .nextQuestionId(7)
                        .id(7)
                        .text("Попробовать старые консервы")
                        .build()
        );

        answers.add(
                Answer.builder()
                        .currentQuestionId(5)
                        .nextQuestionId(8)
                        .id(8)
                        .text("Идти дальше")
                        .build()
        );

        return answers;
    }
}
