package lesson1_ibatis.mappers;

import lesson1_ibatis.domain.Student;

import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 14.11.2017.
 */

public interface StudentMapper {
    List<Student> findAllStudents();
    Student findStudentById(Integer id);
    void insertStudent(Student student);
}

    