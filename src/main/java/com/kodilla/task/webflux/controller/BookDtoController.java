package com.kodilla.task.webflux.controller;


import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodilla.task.webflux.domain.BookDto;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/books")
public class BookDtoController {

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<BookDto> getStrings() {
        return Flux
                .just(new BookDto("Władca Pierścieni", "J.R.R. Tolkien", 1954),
                        new BookDto("Silmarillion", "J.R.R. Tolkien", 1977),
                        new BookDto("Hobbit", "J.R.R. Tolkien", 1937),
                        new BookDto("Księga zaginionych opowieści", "J.R.R. Tolkien", 1983))
                .delayElements(Duration.ofSeconds(2))
                .log();
    }
}
