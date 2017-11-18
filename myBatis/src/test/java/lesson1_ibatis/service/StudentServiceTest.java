package lesson1_ibatis.service;

import lesson1_ibatis.domain.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 19.11.2017.
 */
public class StudentServiceTest {
    private static  StudentService studentService;

    @Before
    public void init(){
        studentService = new StudentService();
    }

    @After
    public void tearDown(){
        studentService = null;
    }

    @Test
    public void testFindAllStudents() throws Exception {
        List<Student> students = studentService.findAllStudents();
        Assert.assertNotNull(students);
        for(Student student : students){
            System.out.println(student);
        }
    }

    @Test
    public void findStudentById() throws Exception {
        Student student = studentService.findStudentById(1);
        Assert.assertNotNull(student);
        System.out.println(student);
    }

    @Test
    public void insertStudent() throws Exception {Student student = new Student();
        int id = 3;
        student.setId(id);
        student.setName("student_"+id);
        student.setEmail("student_"+id+"gmail.com");
        student.setDob(new Date());
        studentService.insertStudent(student);
        Student newStudent = studentService.findStudentById(id);
        Assert.assertNotNull(newStudent);
    }

}