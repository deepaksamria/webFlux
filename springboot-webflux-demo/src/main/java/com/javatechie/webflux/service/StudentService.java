package com.javatechie.webflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.webflux.dao.StudentDao;
import com.javatechie.webflux.dto.Student;

import reactor.core.publisher.Flux;

@Service
public class StudentService {

    @Autowired
    private StudentDao StudentDao;


    public List<Student> getAllStudents() {
        long start = System.currentTimeMillis();
        List<Student> students = StudentDao.getStudents();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return students;
    }



    public Flux<Student> getAllStudentsWebFlux() {
        long start = System.currentTimeMillis();
        Flux<Student> students = StudentDao.getStudentsWebFlux();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return students;
    }
}
