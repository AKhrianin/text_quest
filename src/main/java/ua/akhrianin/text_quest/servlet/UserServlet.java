package ua.akhrianin.text_quest.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.akhrianin.text_quest.entity.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(UserServlet.class);
    private Map<String, User> userRepository = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        userRepository = (Map<String, User>) servletContext.getAttribute("userRepository");
        logger.debug("user repository init:" + userRepository.values()); //clean from final version
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        logger.info("request params: " + req.getAttributeNames());
        logger.info("username input: " + username);
        User user;
        HttpSession session = req.getSession();

        if (session.getAttribute("user") != null) {
            logger.info("new user" + username);
            resp.sendRedirect("dialog");
            return;
        }

        if (userRepository.containsKey(username)){
            logger.info("old user upload from repo" + username);
            user = userRepository.get(username);
        } else {
            user = new User();
            user.setUsername(username);
            user.setGameCount(1);
            userRepository.put(username,user);
            logger.info("new user creation" + user);
        }
        session.setAttribute("user", user);
        resp.sendRedirect("dialog");
    }
}
