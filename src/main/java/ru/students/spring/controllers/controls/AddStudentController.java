package ru.students.spring.controllers.controls;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.students.spring.models.POJO.Students;
import ru.students.spring.services.IStudentService;

/**
 * Created by Ирина on 23.02.2017.
 */
@Controller
public class AddStudentController {
    private static Logger logger = Logger.getLogger(AddStudentController.class);

    private IStudentService studentService;

    @Autowired(required = true)
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/viewFormAddStudent", method = RequestMethod.POST)
    public ModelAndView viewFormAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addStudent");
        return modelAndView;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView showChoisePage(@ModelAttribute("student") Students students) {
        ModelAndView modelAndView = null;
        if (studentService.addStudent(students.getName(), students.getAge(), students.getId_group())) {
            modelAndView = new ModelAndView("redirect:/list");
        } else {
            modelAndView = new ModelAndView("error");
        }
        return modelAndView;
    }
}
