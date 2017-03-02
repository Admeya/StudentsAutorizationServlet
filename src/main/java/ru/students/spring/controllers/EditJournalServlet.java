package ru.students.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.students.spring.models.POJO.Journal;
import org.apache.log4j.Logger;
import ru.students.spring.services.IJournalService;
import ru.students.spring.services.JournalServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ирина on 23.02.2017.
 */
public class EditJournalServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(EditJournalServlet.class);

    private IJournalService journalService;

    @Autowired(required = true)
    public void setJournalService(IJournalService journalService) {
        this.journalService = journalService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idJourn = req.getParameter("idJournal");
        if (idJourn != null) {
            int idJournal = Integer.parseInt(idJourn);

            Journal journal = journalService.getJournalByID(idJournal);
            req.setAttribute("Journal", journal);
            req.getRequestDispatcher("/editJournal.jsp").forward(req, resp);
        } else {
            logger.trace("false");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int journalId = Integer.parseInt(req.getParameter("journalID"));
        int groupId = Integer.parseInt(req.getParameter("idGroup"));
        int lessonId = Integer.parseInt(req.getParameter("idLection"));
        Date dateLec = null;
        try {
            dateLec = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(req.getParameter("dateLection")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String timeLec = req.getParameter("timeLection");

        if (journalService.updateJournal(journalId, groupId, lessonId, dateLec, timeLec)) {
            logger.trace("true");
            resp.sendRedirect("/students/listLection");
        } else {
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
