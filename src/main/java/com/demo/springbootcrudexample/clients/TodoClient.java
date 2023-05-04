package com.demo.springbootcrudexample.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TodoClient {

    WebClient todoClient = WebClient.builder();

    public String getTodos() {
        return todoClient
                .get()
                .uri("http://dummyjson.com/todos/1")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
