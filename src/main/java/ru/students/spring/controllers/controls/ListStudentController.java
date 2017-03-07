package ru.students.spring.controllers.controls;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.students.spring.models.POJO.Students;
import ru.students.spring.services.IStudentService;

import java.util.List;

/**
 * Created by Ирина on 23.02.2017.
 */
@Controller
public class ListStudentController {
    private static Logger logger = Logger.getLogger(ListLectionController.class);

    private IStudentService studentService;

    @Autowired(required = true)
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showListStudentPage(@RequestParam(value = "idStudent", required = false) Integer idStudent) {
        ModelAndView modelAndView = new ModelAndView();
        if (idStudent != null) {
            if (studentService.deleteStudent(idStudent)) {
                modelAndView = new ModelAndView("redirect:/list");
            } else {
                modelAndView = new ModelAndView("error");
            }
        } else {
            modelAndView.setViewName("list");
            List<Students> studentsList = studentService.getAllStudents();
            modelAndView.addObject("studentList", studentsList);
        }
        return modelAndView;
    }
}
