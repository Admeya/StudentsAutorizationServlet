package ru.students.spring.services;

import ru.students.spring.exceptions.UserDAOException;
import ru.students.spring.models.POJO.User;

/**
 * Created by Ирина on 02.03.2017.
 */
public interface IUserService {
    boolean authorize(String login, String password) throws UserDAOException;

    boolean registration(String login, String password);

    User authorize(String login) throws UserDAOException;
}
