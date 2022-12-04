package ua.akhrianin.text_quest.servlet;

import ua.akhrianin.text_quest.entity.Answer;
import ua.akhrianin.text_quest.entity.Question;
import ua.akhrianin.text_quest.entity.User;
import ua.akhrianin.text_quest.initialization.GameInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext =servletContextEvent.getServletContext();
        GameInitializer initializer = new GameInitializer();

        Map<String, User> userRepository = new HashMap<>();
        servletContext.setAttribute("userRepository", userRepository);

        Map<Integer, Question> questionRepository = new HashMap<>();
        for (Question question: initializer.getQuestions()) {
            questionRepository.put(question.getId(), question);
        }
        servletContext.setAttribute("questionRepository", questionRepository);


        Map<Integer, Answer> answerRepository = new HashMap<>();
        for (Answer answer: initializer.getAnswers()) {
            answerRepository.put(answer.getId(), answer);
        }
        servletContext.setAttribute("answerRepository", answerRepository);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
    }
}
