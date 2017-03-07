package ru.students.spring.controllers.controls;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.students.spring.services.IUserService;


/**
 * Created by Ирина on 23.02.2017.
 */
@Controller
public class RegistrationController {
    private static Logger logger = Logger.getLogger(RegistrationController.class);

    private IUserService userService;

    @Autowired(required = true)
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logoutPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView showChoisePage(@RequestParam(name = "login") String login, @RequestParam(name = "password") String password) {
        ModelAndView modelAndView = null;
        if (userService.registration(login, password)) {
            modelAndView = new ModelAndView("login");
        } else {
            modelAndView = new ModelAndView("error");
        }
        return modelAndView;
    }
}
