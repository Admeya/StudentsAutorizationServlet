package ru.students.spring.models.DAO;

import org.springframework.stereotype.Component;
import ru.students.spring.models.POJO.Journal;
import ru.students.spring.models.connector.Connector;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Created by Ирина on 23.02.2017.
 */
@Component
public class JournalDAO {
    private static final String SQL_CREATE_JOURNAL = "INSERT INTO journal(id_group, id_lesson, datelection, timelection) VALUES(?, ?, ?, ?)";
    private static Logger logger = Logger.getLogger(JournalDAO.class);
    private static String SQL_ALL_JOURNAL = "SELECT j.id as id, j.id_group as id_group, j.id_lesson as id_lection, gr.name as name_group, les.name as name_lection, j.datelection as date_lec, j.timelection as time_lec\n" +
            "FROM journal j left join grouppa gr on j.id_group = gr.id left join lesson les on j.id_lesson = les.id";
    private static String SQL_SELECT_BY_ID_JOURNAL = SQL_ALL_JOURNAL + " where j.id = ?";
    private static String SQL_UPDATE_JOURNAL = "UPDATE  journal SET  id_group = ?, id_lesson = ?, datelection = ?, timelection = ? where id = ?";
    private static String SQL_DELETE_JOURNAL = "DELETE FROM journal WHERE id = ?";

    public ArrayList<Journal> parseResultSet(ResultSet rs) {
        ArrayList<Journal> result = new ArrayList<Journal>();
        try {
            while (rs.next()) {
                Journal journal = new Journal();
                journal.setId(rs.getInt("id"));
                journal.setId_group(rs.getInt("id_group"));
                journal.setId_lesson(rs.getInt("id_lection"));
                journal.setName_group(rs.getString("name_group"));
                journal.setName_lection(rs.getString("name_lection"));
                journal.setDate_lec(rs.getDate("date_lec"));
                journal.setTime_lec(rs.getString("time_lec"));

                result.add(journal);
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception при парсинге записей из таблицы " + e);
        }
        return result;
    }

    public List<Journal> getJournal() {
        List<Journal> journalList = new ArrayList<>();
        try (Connection connection = Connector.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_ALL_JOURNAL);

            journalList = parseResultSet(resultSet);

        } catch (SQLException e) {
            logger.error(e);
        }
        return journalList;
    }

    public Journal getJournalByID(int id) {
        Journal student = new Journal();
        try (Connection connection = Connector.getConnection()) {
            Statement statement = connection.createStatement();

            PreparedStatement prepared = connection.prepareStatement(SQL_SELECT_BY_ID_JOURNAL);
            prepared.setInt(1, id);
            System.out.println(prepared);

            ResultSet rs = prepared.executeQuery();
            List<Journal> studentsList = parseResultSet(rs);
            student = studentsList.get(0);
        } catch (SQLException e) {
            logger.error(e);
        }
        return student;
    }

    public boolean updateJournal(int id, int id_group, int id_lesson, Date datelection, String timelection) {
        try (Connection connection = Connector.getConnection()) {
            PreparedStatement prepared = connection.prepareStatement(SQL_UPDATE_JOURNAL);
            prepared.setInt(1, id_group);
            prepared.setInt(2, id_lesson);
            prepared.setDate(3, new java.sql.Date(datelection.getTime()));
            prepared.setString(4, timelection);
            prepared.setInt(5, id);

            if (prepared.executeUpdate() > 0)
                return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteJournal(int idStud) {

        try (Connection connection = Connector.getConnection()) {
            PreparedStatement prepared = connection.prepareStatement(SQL_DELETE_JOURNAL);
            prepared.setInt(1, idStud);

            if (prepared.executeUpdate() > 0)
                return true;

        } catch (SQLException e) {
            logger.error(e);
        }
        return false;
    }

    public boolean addJournal(int id_group, int id_lection, java.util.Date datelection, String timelection) {
        try (Connection connection = Connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_JOURNAL)) {
            preparedStatement.setInt(1, id_group);
            preparedStatement.setInt(2, id_lection);
            preparedStatement.setDate(3, new java.sql.Date(datelection.getTime()));
            preparedStatement.setString(4, timelection);
            int count = preparedStatement.executeUpdate();

            if (count > 0) {
                logger.debug("inserted " + count);
                return true;
            } else {
                logger.debug("string journal not inserted");
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return false;
    }
}
