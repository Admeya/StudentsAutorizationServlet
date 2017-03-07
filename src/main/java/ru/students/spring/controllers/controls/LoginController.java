package ru.students.spring.controllers.controls;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.servlet.ModelAndView;
import ru.students.spring.exceptions.UserDAOException;
import ru.students.spring.services.IUserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Ирина on 23.02.2017.
 */
@Controller
public class LoginController {
    private static Logger logger = Logger.getLogger(LoginController.class);
    private IUserService userService;

    @Autowired(required = true)
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/choise", method = RequestMethod.POST)
    public ModelAndView showChoisePage(@RequestParam(name = "login") String login, @RequestParam(name = "password") String password) {
        ModelAndView modelAndView = null;
        logger.trace("login " + login + " pass " + password);
        try {
            if (userService.authorize(login, password)) {
                modelAndView = new ModelAndView("choiseAfterLogin");
            } else {
                modelAndView = new ModelAndView("login");
            }
        } catch (UserDAOException e) {
            logger.error(e);
            modelAndView = new ModelAndView("error");
        }

        return modelAndView;
    }
}

