package ru.students.spring.models.DAO;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.students.spring.exceptions.UserDAOException;
import ru.students.spring.models.POJO.User;
import ru.students.spring.models.connector.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ирина on 23.02.2017.
 */
@Component
public class UserDAO {

    private static final String SQL_FIND_USER =
            "SELECT * FROM public.user WHERE login=? AND password=?";

    private static final String SQL_FIND_USER_BY_LOGIN =
            "SELECT * FROM public.user WHERE login=?";

    private static final String SQL_CREATE_USER =
            "INSERT INTO public.user(login, password, role) " +
                    "VALUES(?, ?, ?)";
    private static Logger logger = Logger.getLogger(UserDAO.class);

    public static boolean registrationUser(String login, String password) {
        try (Connection connection = Connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_USER)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, "user");
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                logger.debug("inserted " + count);
                return true;
            } else {
                logger.debug(login + " " + password + " not inserted");
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return false;
    }

    public User getUserByLoginAndPassword(String login, String password) throws UserDAOException {

        logger.debug(login + " " + password);
        User user = null;
        try (Connection connection = Connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USER)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                logger.debug("find");
                user = new User(
                        resultSet.getInt("id_user"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
            } else {
                logger.debug(login + " " + password + " not found");
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new UserDAOException();
        }
        return user;
    }

    public User getUserByLogin(String login) {
        User user = null;
        try (Connection connection = Connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                logger.debug("find " + resultSet);
                user = new User(
                        resultSet.getInt("id_user"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
            } else {
                logger.debug(login + " not found");
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return user;
    }
}
