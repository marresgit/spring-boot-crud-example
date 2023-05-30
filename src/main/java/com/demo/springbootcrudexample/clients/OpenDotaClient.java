package com.demo.springbootcrudexample.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OpenDotaClient {

    WebClient openDotaClient = WebClient.builder().build();

    public String getSteveAPI(String args[]) {
        return openDotaClient
                .get()
//                .uri("https://catfact.ninja/fact?max_length=140")
                .uri("https://api.opendota.com/api/players/62297546?api")
//                .headers(headers -> headers.setBasicAuth("username", "password")) # Username & password
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}


//Steve=62297546