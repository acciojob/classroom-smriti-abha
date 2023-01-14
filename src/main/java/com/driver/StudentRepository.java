package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public class StudentRepository {
    HashMap<String,Student> studentMap = new HashMap<>();
    HashMap<String,Teacher> teacherMap = new HashMap<>();
    HashMap<String, List<Student>> pairStudentTeacherMap = new HashMap<>();

    public void addStudentInDb(Student student){
        String key = student.getName();
        studentMap.put(key,student);

    }
    public void addTeacherInDb(Teacher teacher){
        String key = teacher.getName();
        teacherMap.put(key,teacher);

    }
    public void addPairOfStudentAndTeacherInDb(String studentName,String teacherName){
        if(studentMap.containsKey(studentName) && teacherMap.containsKey(teacherName)){
            List<Student> StudentList = new ArrayList<>();
            if(pairStudentTeacherMap.containsKey(teacherName)){

                StudentList = pairStudentTeacherMap.get(teacherName);
            }
            StudentList.add(studentMap.get(studentName));
            pairStudentTeacherMap.put(teacherName,StudentList);
        }

    }
    public Student getStudentFromDb(String studentName){
        if(studentMap.containsKey(studentName)){
            return studentMap.get(studentName);
        }
        return null;
    }
    public Teacher getTeacherFromDb(String teacherName){
        if(teacherMap.containsKey(teacherName)){
            return teacherMap.get(teacherName);
        }
        return null;
    }
    public List<String> getListOfStudentByTeacherName(String teacherName){

        if(pairStudentTeacherMap.containsKey(teacherName)) {
            List<String> studentName = new ArrayList<>();
            List <Student> studentList = pairStudentTeacherMap.get(teacherName);
            for (Student student : studentList) {
                studentName.add(student.getName());
            }
            return  studentName;
        }
        return null;
    }
    public List<String> listOfStudentFromDb(){
        List<String> studentList = new ArrayList<>();
        for(Student EntrySet :  studentMap.values()){
            studentList.add(EntrySet.getName());
        }
        return  studentList;
    }
    public void deleteTeacherByNameInDb(String teacherName){
        if(pairStudentTeacherMap.containsKey(teacherName)){
            List<Student> studentList = pairStudentTeacherMap.get(teacherName);
            for (Student student : studentList) {
                studentMap.remove(student.getName());
            }
            teacherMap.remove(teacherName);
            pairStudentTeacherMap.remove(teacherName);

        }

    }
    public void deleteAllTeacherAndItsStudent(){
        pairStudentTeacherMap.forEach((key, value) -> {
            List<Student> studentList = pairStudentTeacherMap.get(key);
            for (Student student : studentList) {
                studentMap.remove(student.getName());
            }
        });
        pairStudentTeacherMap.clear();
        teacherMap.clear();


    }
}
