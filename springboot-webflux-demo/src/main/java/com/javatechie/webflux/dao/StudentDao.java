package com.javatechie.webflux.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.javatechie.webflux.dto.Student;

import reactor.core.publisher.Flux;

@Component
public class StudentDao {


    private static void sleepExecution(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudents()  {
        return IntStream.rangeClosed(1, 10)
                .peek(StudentDao::sleepExecution)
                .peek(i -> System.out.println("count : " + i))
                .mapToObj(i -> new Student(i, "name" + i, "city"+i))
                .collect(Collectors.toList());
    }


    public Flux<Student> getStudentsWebFlux()  {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("count: " + i))
                .map(i -> new Student(i, "name" + i, "city"+i));
    }


//    public Flux<Customer> getCustomerList()  {
//        return Flux.range(1,50)
//                .doOnNext(i -> System.out.println("processing count in stream flow : " + i))
//                .map(i -> new Customer(i, "customer" + i));
//    }
}
