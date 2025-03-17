package com.example.springwebserver;

import com.example.springwebserver.model.Info;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class WebController {

    private final String id = "Web Server Node " + UUID.randomUUID();
    private Joker joker;

    public WebController(Joker joker) {
        this.joker = joker;
    }

    @GetMapping(path = "/whereami")
    public Mono<JsonNode> whereami() {
        return WebClient.create()
            .get()
            .uri("http://ip-api.com/json")
            .retrieve()
            .bodyToMono(JsonNode.class);
    }

    @GetMapping(path = "/whoami")
    public String whoami() {
        return "Id: " + id;
    }

    @GetMapping
    public Mono<Info> info() {
        return whereami().map(whereami -> new Info(id, whereami.toString(),
            joker.joke(whereami.get("city").asText(), whereami.get("country").asText())));
    }
}
