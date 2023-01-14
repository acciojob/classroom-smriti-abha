package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository; // create object automatically
    public void addStudent(Student student){
        studentRepository.addStudentInDb(student);
    }
    public void addTeacher(Teacher teacher){
        studentRepository.addTeacherInDb(teacher);

    }
    public void addPairOfTeacherAndStudent(String studentName, String teacherName){
        studentRepository.addPairOfStudentAndTeacherInDb(studentName,teacherName);

    }
    public Student getStudentByName(String StudentName){
        return studentRepository.getStudentFromDb(StudentName);
    }
    public Teacher getTeacherByName(String teacherName){
        return studentRepository.getTeacherFromDb(teacherName);
    }
    public List<String> getStudentsByTeacherName(String teacherName){
        return studentRepository.getListOfStudentByTeacherName(teacherName);
    }
    public List<String> getAllStudents(){
        return studentRepository.listOfStudentFromDb();
    }
    public void deleteTeacherByName(String teacherName){
        studentRepository.deleteTeacherByNameInDb(teacherName);
    }
    public void deleteAllTeacherAndItsStudent(){
        studentRepository.deleteAllTeacherAndItsStudent();
    }
}
