package ru.students.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.students.spring.models.DAO.StudentDAO;
import ru.students.spring.models.POJO.Students;

import java.util.List;

/**
 * Created by Ирина on 23.02.2017.
 */
@Service
public class StudentServiceImpl implements IStudentService {
    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Students> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public Students getStudentByID(int id) {
        return studentDAO.getStudentByID(id);
    }

    public boolean updateStudent(int idStud, String name, int age, int id_group) {
        return studentDAO.updateStudent(idStud, name, age, id_group);
    }

    public boolean deleteStudent(int idStud) {
        return studentDAO.deleteStudent(idStud);
    }

    public boolean addStudent(String studName, int studAge, int idStud) {
        return studentDAO.addStudent(studName, studAge, idStud);
    }
}
