package com.javatechie.webflux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.webflux.dto.Student;
import com.javatechie.webflux.service.StudentService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;


    @GetMapping()
    public List<Student> getAllStudnetsWithoutFlux() {
        return service.getAllStudents();
    }

    @GetMapping(value = "/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> getAllStudentsWebFlux() {
        return service.getAllStudentsWebFlux();
    }
}
