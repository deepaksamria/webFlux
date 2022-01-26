package com.javatechie.webflux.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.javatechie.webflux.handler.StudentHandler;
import com.javatechie.webflux.handler.StudentStreamHandler;

@Configuration
public class RouterConfig {

    @Autowired
    private StudentHandler handler;

    @Autowired
    private StudentStreamHandler streamHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
      //          .GET("/router/customers",handler::loadCustomers)
                .GET("/router/customers/stream",streamHandler::getCustomers)
//                .GET("/router/customer/{input}",handler::findCustomer)
//                .POST("/router/customer/save",handler::saveCustomer)
                .build();

    }
}
