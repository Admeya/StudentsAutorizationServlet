package services;

import common.exceptions.UserDAOException;
import models.DAO.UserDAO;

/**
 * Created by Ирина on 23.02.2017.
 */
public class UserService {
    public static boolean authorize(String login, String pass) throws UserDAOException {
        if (UserDAO.getUserByLoginAndPassword(login, pass).getId() != 0) {
            return true;
        } else
            return false;
    }

    public static boolean registration(String login, String password){
        return UserDAO.registrationUser(login, password);
    }
}
