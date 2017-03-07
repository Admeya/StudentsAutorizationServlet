package ru.students.spring.controllers.controls;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.students.spring.models.DAO.JournalDAO;
import ru.students.spring.models.POJO.Journal;

/**
 * Created by Ирина on 23.02.2017.
 */
@Controller
public class AddJournalController {
    private static Logger logger = Logger.getLogger(AddJournalController.class);

    private JournalDAO journalDAO;

    @Autowired
    public AddJournalController(JournalDAO journalDAO) {
        this.journalDAO = journalDAO;
    }

    @RequestMapping(value = "/viewFormAddJournal", method = RequestMethod.POST)
    public ModelAndView viewFormAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addJournal");
        return modelAndView;
    }

    @RequestMapping(value = "/addJournal", method = RequestMethod.POST)
    public ModelAndView showChoisePage(@ModelAttribute("journal") Journal journal) {
        ModelAndView modelAndView = null;
        if (journalDAO.addJournal(journal.getId_group(), journal.getId_lesson(), journal.getDate_lec(), journal.getTime_lec())) {
            modelAndView = new ModelAndView("redirect:/listLection");
        } else {
            modelAndView = new ModelAndView("error");
        }
        return modelAndView;
    }
}
