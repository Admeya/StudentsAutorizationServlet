package ru.students.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.students.spring.models.POJO.Students;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import ru.students.spring.services.IStudentService;
import ru.students.spring.services.StudentServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ирина on 23.02.2017.
 */
public class EditServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(LoginServlet.class);
    static {
        PropertyConfigurator.configure("src/main/resources/log4j.xml");
    }

    private IStudentService studentService;

    @Autowired(required = true)
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idStudent = Integer.parseInt(req.getParameter("idStudent"));

        Students student = studentService.getStudentByID(idStudent);
        req.setAttribute("studentID", student);
        req.getRequestDispatcher("/editStudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int studId = Integer.parseInt(req.getParameter("studID"));
        String studName = req.getParameter("studName");
        int studAge = Integer.parseInt(req.getParameter("studAge"));
        int studIdGroup = Integer.parseInt(req.getParameter("studIdGroup"));
        if (studentService.updateStudent(studId, studName, studAge, studIdGroup)) {
            logger.trace("true");
            resp.sendRedirect("/students/list");
        }else{
            logger.trace("false");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }
}
