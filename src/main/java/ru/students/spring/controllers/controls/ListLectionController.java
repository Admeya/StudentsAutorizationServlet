package ru.students.spring.controllers.controls;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.students.spring.models.POJO.Journal;
import ru.students.spring.services.IJournalService;

import java.util.List;

/**
 * Created by Ирина on 23.02.2017.
 */
@Controller
public class ListLectionController {
    private static Logger logger = Logger.getLogger(ListLectionController.class);

    private IJournalService journalService;

    @Autowired(required = true)
    public void setJournalService(IJournalService journalService) {
        this.journalService = journalService;
    }

    @RequestMapping(value = "/listLection", method = RequestMethod.GET)
    public ModelAndView showListLectionPage(@RequestParam(value = "idJournal", required = false) Integer idJournal) {
        ModelAndView modelAndView = new ModelAndView();
        if (idJournal != null) {
            if (journalService.deleteJournal(idJournal)) {
                modelAndView = new ModelAndView("redirect:/listLection");
            } else {
                modelAndView = new ModelAndView("error");
            }
        } else {
            modelAndView.setViewName("listJournal");
            List<Journal> journalList = journalService.getJournal();
            modelAndView.addObject("journalList", journalList);
        }
        return modelAndView;
    }
}
