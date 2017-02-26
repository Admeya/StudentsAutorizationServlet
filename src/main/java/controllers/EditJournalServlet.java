package controllers;

import models.POJO.Journal;
import org.apache.log4j.Logger;
import services.JournalService;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idJourn = req.getParameter("idJournal");
        if (idJourn != null) {
            int idJournal = Integer.parseInt(idJourn);

            Journal journal = JournalService.getJournalByID(idJournal);
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

        if (JournalService.updateJournal(journalId, groupId, lessonId, dateLec, timeLec)) {
            logger.trace("true");
            resp.sendRedirect("/students/listLection");
        } else {
            logger.trace("false");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
