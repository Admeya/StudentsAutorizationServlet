package controllers;

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
public class AddJournalServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int groupId = Integer.parseInt(req.getParameter("idGroup"));
        int lessonId = Integer.parseInt(req.getParameter("idLection"));
        Date dateLec = null;
        try {
            dateLec = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dateLection"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String timeLec = req.getParameter("timeLection");

        if (JournalService.addJournal(groupId, lessonId, dateLec, timeLec)) {
            logger.trace("true");
            resp.sendRedirect("/students/listLection");
        } else {
            logger.trace("false");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }

    }
}
