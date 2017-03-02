package ru.students.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.students.spring.models.DAO.JournalDAO;
import ru.students.spring.models.DAO.StudentDAO;
import ru.students.spring.models.POJO.Journal;

import java.util.Date;
import java.util.List;

/**
 * Created by Ирина on 23.02.2017.
 */
@Service
public class JournalServiceImpl implements IJournalService {

    private JournalDAO journalDAO;

    @Autowired
    public JournalServiceImpl(JournalDAO journalDAO) {
        this.journalDAO = journalDAO;
    }

    public List<Journal> getJournal() {
        return journalDAO.getJournal();
    }

    public Journal getJournalByID(int idJournal) {
        return journalDAO.getJournalByID(idJournal);
    }

    public boolean updateJournal(int id, int id_group, int id_lesson, Date datelection, String timelection) {
        return journalDAO.updateJournal(id, id_group, id_lesson, datelection, timelection);
    }

    public boolean deleteJournal(int idStud) {
        return journalDAO.deleteJournal(idStud);
    }

    public boolean addJournal(int id_group, int id_lection, java.util.Date datelection, String timelection) {
        return journalDAO.addJournal(id_group, id_lection, datelection, timelection);
    }
}
