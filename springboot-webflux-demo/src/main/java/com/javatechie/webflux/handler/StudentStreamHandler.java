package com.javatechie.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.javatechie.webflux.dao.StudentDao;
import com.javatechie.webflux.dto.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentStreamHandler {

	@Autowired
    private StudentDao studentDao;


    public Mono<ServerResponse> getCustomers(ServerRequest request) {
        Flux<Student> studentMono = studentDao.getStudentsWebFlux();
        return ServerResponse.ok().
                contentType(MediaType.TEXT_EVENT_STREAM)
                .body(studentMono, Student.class);
    }
}
