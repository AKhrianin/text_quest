package ua.akhrianin.text_quest.servlet;

import ua.akhrianin.text_quest.entity.Answer;
import ua.akhrianin.text_quest.entity.Question;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet (name = "DialogServlet", value = "/dialog")
public class DialogServlet extends HttpServlet {
    private final int STARTING_QUESTION_ID = 1;
    private Map<Integer, Question> questionRepository = null;
    private Map<Integer, Answer> answerRepository = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        questionRepository = (Map<Integer, Question>) servletContext.getAttribute("questionRepository");
        answerRepository = (Map<Integer, Answer>) servletContext.getAttribute("answerRepository");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //HttpSession session = req.getSession();
        Question question;
        List <Answer> answers;

        if (req.getParameter("answer") == null){
            question = questionRepository.get(STARTING_QUESTION_ID);
            req.setAttribute("currentQuestion", question);
            answers = answerRepository
                    .values()
                    .stream()
                    .filter(answer -> answer.getCurrentQuestionId() == question.getId())
                    .collect(Collectors.toList());
            req.setAttribute("currentAnswers", answers);
        } else {
            question = questionRepository.get(req.getParameter("answer"));
            req.setAttribute("currentQuestion", question);
            answers = answerRepository
                    .values()
                    .stream()
                    .filter(answer -> answer.getCurrentQuestionId() == question.getId())
                    .collect(Collectors.toList());
            req.setAttribute("currentAnswers", answers);
        }
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/dialog.jsp")
                .forward(req, resp);
    }
}
