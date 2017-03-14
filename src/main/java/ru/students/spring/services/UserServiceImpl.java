package ru.students.spring.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import ru.students.spring.exceptions.UserDAOException;
import ru.students.spring.models.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.students.spring.models.POJO.User;

import java.util.Random;

/**
 * Created by Ирина on 23.02.2017.
 */
@Service
public class UserServiceImpl implements IUserService {
    private UserDAO userDAO;
    private int anInt = 0;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean authorize(String login, String pass) throws UserDAOException {
        if (anInt == 0) {
            Random random = new Random(100);
            anInt = random.nextInt();
        }

        if (userDAO.getUserByLoginAndPassword(login, pass).getId() != 0) {
            return true;
        } else
            return false;
    }

    public boolean registration(String login, String password) {
        return userDAO.registrationUser(login, password);
    }

    public User authorize(String login) {
        return userDAO.getUserByLogin(login);
    }
}
