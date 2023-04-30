package com.demo.springbootcrudexample.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TodoClient {

    WebClient todoClient = WebClient.create();

    public String getTodos() {
        return todoClient.get()
                .uri(uri -> uri.path("http://dummyjson.com/todos/1")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
