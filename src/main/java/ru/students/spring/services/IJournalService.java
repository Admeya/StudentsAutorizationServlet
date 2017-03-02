package ru.students.spring.services;

import ru.students.spring.models.POJO.Journal;

import java.util.Date;
import java.util.List;

/**
 * Created by Ирина on 02.03.2017.
 */
public interface IJournalService {
    List<Journal> getJournal();

    Journal getJournalByID(int idJournal);

    boolean updateJournal(int id, int id_group, int id_lesson, Date datelection, String timelection);

    boolean deleteJournal(int idStud);

    boolean addJournal(int id_group, int id_lection, java.util.Date datelection, String timelection);

}
