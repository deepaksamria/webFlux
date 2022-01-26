package com.javatechie.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.javatechie.webflux.dao.StudentDao;
import com.javatechie.webflux.dto.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentHandler {

	@Autowired
    private StudentDao studentDao;


    public Mono<ServerResponse> getStudents(ServerRequest request){
        Flux<Student> studentList = studentDao.getStudentsWebFlux();
        return ServerResponse.ok().body(studentList, Student.class);
    }


//    public Mono<ServerResponse> findCustomer(ServerRequest request){
//      int customerId= Integer.valueOf( request.pathVariable("input"));
//       // dao.getCustomerList().filter(c->c.getId()==customerId).take(1).single();
//        Mono<Customer> customerMono = dao.getCustomerList().filter(c -> c.getId() == customerId).next();
//        return ServerResponse.ok().body(customerMono,Customer.class);
//    }
//
//
//    public Mono<ServerResponse> saveCustomer(ServerRequest request){
//        Mono<Customer> customerMono = request.bodyToMono(Customer.class);
//        Mono<String> saveResponse = customerMono.map(dto -> dto.getId() + ":" + dto.getName());
//        return ServerResponse.ok().body(saveResponse,String.class);
//    }



}
