package com.demo.springbootcrudexample.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TodoClient {

    WebClient todoClient = WebClient.builder().build();

    public String getTodos() {
        return todoClient
                .get()
//                .uri("https://catfact.ninja/fact?max_length=140")
                .uri("https://api.opendota.com/api/matches/62297546?api=${API_KEY}")
//                .headers(headers -> headers.setBasicAuth("username", "password")) # Username & password
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
