package ru.students.spring.controllers.controls;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.servlet.ModelAndView;
import ru.students.spring.models.POJO.Journal;
import ru.students.spring.models.POJO.Students;
import ru.students.spring.services.IJournalService;

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
@Controller
public class EditJournalController extends HttpServlet {
    private static Logger logger = Logger.getLogger(EditJournalController.class);

    private IJournalService journalService;

    @Autowired(required = true)
    public void setJournalService(IJournalService journalService) {
        this.journalService = journalService;
    }

    @RequestMapping(value = "/editJournal", method = RequestMethod.GET)
    public ModelAndView showEditStudentPage(@RequestParam("idJournal") int idJournal) {
        ModelAndView modelAndView = new ModelAndView("editJournal");
        Journal journal = journalService.getJournalByID(idJournal);
        modelAndView.addObject("Journal", journal);
        return modelAndView;
    }

    @RequestMapping(value = "/editJournal", method = RequestMethod.POST)
    public ModelAndView showChoisePage(@ModelAttribute("journal") Journal journal) {
        ModelAndView modelAndView = null;
        if (journalService.updateJournal(journal.getId(), journal.getId_group(), journal.getId_lesson(), journal.getDate_lec(), journal.getTime_lec())) {
            modelAndView = new ModelAndView("redirect:/listLection");
        } else {
            modelAndView = new ModelAndView("error");
        }
        return modelAndView;
    }
}
