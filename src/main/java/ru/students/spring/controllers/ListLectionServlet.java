package ru.students.spring.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.students.spring.models.POJO.Journal;
import ru.students.spring.services.IJournalService;

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
public class ListLectionServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(ListLectionServlet.class);

    private IJournalService journalService;

    @Autowired(required = true)
    public void setJournalService(IJournalService journalService) {
        this.journalService = journalService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("idJournal");

        if (paramId != null) {
            int studId = Integer.parseInt(paramId);
            if (journalService.deleteJournal(studId)) {
                logger.trace("true");
                resp.sendRedirect("/students/listLection");
            } else {
                logger.trace("false");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } else {
            List<Journal> journalList = journalService.getJournal();
            req.setAttribute("journalList", journalList);
            req.getRequestDispatcher("/listJournal.jsp").forward(req, resp);
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
