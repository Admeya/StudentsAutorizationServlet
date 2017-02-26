package services;

import models.DAO.JournalDAO;
import models.POJO.Journal;

import java.util.Date;
import java.util.List;

/**
 * Created by Ирина on 23.02.2017.
 */
public class JournalService {

    public static List<Journal> getJournal() {
        return JournalDAO.getJournal();
    }

    public static Journal getJournalByID(int idJournal) {
        return JournalDAO.getJournalByID(idJournal);
    }

    public static boolean updateJournal(int id, int id_group, int id_lesson, Date datelection, String timelection) {
        return JournalDAO.updateJournal(id, id_group, id_lesson, datelection, timelection);
    }

    public static boolean deleteJournal(int idStud) {
        return JournalDAO.deleteJournal(idStud);
    }

    public static boolean addJournal(int id_group, int id_lection, java.util.Date datelection, String timelection) {
        return JournalDAO.addJournal(id_group, id_lection, datelection, timelection);
    }


}
