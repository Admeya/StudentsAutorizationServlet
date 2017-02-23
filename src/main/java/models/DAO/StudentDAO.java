package models.DAO;

import models.POJO.Students;
import models.connector.Connector;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ирина on 23.02.2017.
 */
public class StudentDAO {

    private static Logger logger = Logger.getLogger(StudentDAO.class);

    private static String SQL_ALL_STUDENTS = "SELECT * FROM student";
    private static String SQL_SELECT_BY_ID_STUDENT = SQL_ALL_STUDENTS + " where id = ?";
    private static String SQL_UPDATE_STUDENT = "UPDATE  student SET  name = ?, age = ?, id_group = ? where id = ?";
    private static String SQL_DELETE_BY_ID_STUDENT = "DELETE FROM student WHERE id = ?";
    private static final String SQL_CREATE_STUDENT = "INSERT INTO student(name, age, id_group) VALUES(?, ?, ?)";

    public static ArrayList<Students> parseResultSet(ResultSet rs) {
        ArrayList<Students> result = new ArrayList<Students>();
        try {
            while (rs.next()) {
                Students stud = new Students();
                stud.setId(rs.getInt("id"));
                stud.setName(rs.getString("name".trim()));
                stud.setAge(rs.getInt("age"));
                stud.setId_group(rs.getInt("id_group"));

                result.add(stud);
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception при парсинге записей из таблицы " + e);
        }
        return result;
    }

    public static List<Students> getAllStudents() {
        List<Students> studentsList = new ArrayList<>();
        try (Connection connection = Connector.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_ALL_STUDENTS);

            studentsList = parseResultSet(resultSet);

        } catch (SQLException e) {
            logger.error(e);
        }
        return studentsList;
    }

    public static Students getStudentByID(int id) {
        Students student = new Students();
        try (Connection connection = Connector.getConnection()) {
            Statement statement = connection.createStatement();

            PreparedStatement prepared = connection.prepareStatement(SQL_SELECT_BY_ID_STUDENT);
            prepared.setInt(1, id);
            System.out.println(prepared);

            ResultSet rs = prepared.executeQuery();
            List<Students> studentsList = parseResultSet(rs);
            student = studentsList.get(0);
        } catch (SQLException e) {
            logger.error(e);
        }
        return student;
    }

    public static boolean updateStudent(int idStud, String name, int age, int id_group) {
        try (Connection connection = Connector.getConnection()) {
            PreparedStatement prepared = connection.prepareStatement(SQL_UPDATE_STUDENT);
            prepared.setString(1, name);
            prepared.setInt(2, age);
            prepared.setInt(3, id_group);
            prepared.setInt(4, idStud);

            if (prepared.executeUpdate() > 0)
                return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean deleteStudent(int idStud) {

        try (Connection connection = Connector.getConnection()) {
            PreparedStatement prepared = connection.prepareStatement(SQL_DELETE_BY_ID_STUDENT);
            prepared.setInt(1, idStud);

            if (prepared.executeUpdate() > 0)
                return true;

        } catch (SQLException e) {
            logger.error(e);
        }
        return false;
    }

    public static boolean addStudent(String studName, int studAge, int idStud) {
        try (Connection connection = Connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_STUDENT)) {
            preparedStatement.setString(1, studName);
            preparedStatement.setInt(2, studAge);
            preparedStatement.setInt(3, idStud);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                logger.debug("inserted " + count);
                return true;
            } else {
                logger.debug("student not inserted");
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return false;
    }
}
