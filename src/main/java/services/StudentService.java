package services;

import models.DAO.StudentDAO;
import models.POJO.Students;

import java.util.List;

/**
 * Created by Ирина on 23.02.2017.
 */
public class StudentService {

    public static List<Students> getAllStudents(){
        return StudentDAO.getAllStudents();
    }

    public static Students getStudentByID(int id){
        return StudentDAO.getStudentByID(id);
    }

    public static boolean updateStudent(int idStud, String name, int age, int id_group){
        return StudentDAO.updateStudent(idStud, name, age, id_group);
    }

    public static boolean deleteStudent(int idStud){
        return StudentDAO.deleteStudent(idStud);
    }

    public static boolean addStudent(String studName, int studAge, int idStud){
        return StudentDAO.addStudent(studName, studAge, idStud);
    }

}
