package ru.students.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.students.spring.models.POJO.Students;
import org.apache.log4j.Logger;
import ru.students.spring.services.IStudentService;
import ru.students.spring.services.IUserService;
import ru.students.spring.services.StudentServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ирина on 23.02.2017.
 */
public class ListServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(LoginServlet.class);

    private IStudentService studentService;

    @Autowired(required = true)
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("idStudent");

        if (paramId != null) {
            int studId = Integer.parseInt(paramId);
            if (studentService.deleteStudent(studId)) {
                logger.trace("true");
                resp.sendRedirect("/students/list");
            } else {
                logger.trace("false");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } else {
            List<Students> studentsList = studentService.getAllStudents();
            req.setAttribute("studentList", studentsList);
            req.getRequestDispatcher("/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }
}
