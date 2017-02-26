package controllers;

import models.POJO.Journal;
import org.apache.log4j.Logger;
import services.JournalService;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("idJournal");

        if (paramId != null) {
            int studId = Integer.parseInt(paramId);
            if (JournalService.deleteJournal(studId)) {
                logger.trace("true");
                resp.sendRedirect("/students/listLection");
            } else {
                logger.trace("false");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } else {
            List<Journal> journalList = JournalService.getJournal();
            req.setAttribute("journalList", journalList);
            req.getRequestDispatcher("/listJournal.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
