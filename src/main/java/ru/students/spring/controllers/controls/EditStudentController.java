package ru.students.spring.controllers.controls;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.students.spring.models.POJO.Students;
import ru.students.spring.services.IStudentService;

/**
 * Created by Ирина on 23.02.2017.
 */
@Controller
public class EditStudentController {
    private static Logger logger = Logger.getLogger(EditStudentController.class);

    static {
        PropertyConfigurator.configure("src/main/resources/log4j.xml");
    }

    private IStudentService studentService;

    @Autowired(required = true)
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/editStudent", method = RequestMethod.GET)
    public ModelAndView showEditStudentPage(@RequestParam("idStudent") int idStudent) {
        ModelAndView modelAndView = new ModelAndView("editStudent");
        Students student = studentService.getStudentByID(idStudent);
        modelAndView.addObject("studentID", student);
        return modelAndView;
    }

    @RequestMapping(value = "/editStudent", method = RequestMethod.POST)
    public ModelAndView showChoisePage(@ModelAttribute("student") Students students) {
        ModelAndView modelAndView = null;
        if (studentService.updateStudent(students.getId(), students.getName(), students.getAge(), students.getId_group())) {
            modelAndView = new ModelAndView("redirect:/list");
        } else {
            modelAndView = new ModelAndView("error");
        }
        return modelAndView;
    }

}
