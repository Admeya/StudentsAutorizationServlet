package ru.students.spring.services;

import ru.students.spring.exceptions.UserDAOException;

/**
 * Created by Ирина on 02.03.2017.
 */
public interface IUserService {
    public boolean authorize(String login, String password) throws UserDAOException;

    public boolean registration(String login, String password);
}
