package controllers;

import models.POJO.Students;
import org.apache.log4j.Logger;
import services.StudentService;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("idStudent");

        if (paramId != null) {
            int studId = Integer.parseInt(paramId);
            if (StudentService.deleteStudent(studId)) {
                logger.trace("true");
                resp.sendRedirect("/students/list");
            } else {
                logger.trace("false");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } else {
            List<Students> studentsList = StudentService.getAllStudents();
            req.setAttribute("studentList", studentsList);
            req.getRequestDispatcher("/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
