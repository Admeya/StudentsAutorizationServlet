package ru.students.spring.services;

import ru.students.spring.models.POJO.Students;

import java.util.List;

/**
 * Created by Ирина on 02.03.2017.
 */
public interface IStudentService {
    List<Students> getAllStudents();

    Students getStudentByID(int id);

    boolean updateStudent(int idStud, String name, int age, int id_group);

    boolean deleteStudent(int idStud);

    boolean addStudent(String studName, int studAge, int idStud);
}
