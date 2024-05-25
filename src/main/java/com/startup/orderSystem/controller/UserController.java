package com.startup.orderSystem.controller;


import com.startup.orderSystem.domain.User;
import com.startup.orderSystem.service.UserService;
import io.netty.handler.codec.socks.SocksRequestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public Flux<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/users/{id}")
    public Mono<User> findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping(value = "/users")
    @ResponseStatus(CREATED)
    public Mono<User> save(@RequestBody User obj) {
        return userService.save(obj);
    }

    @DeleteMapping(value = "/users/{id}")
    public Mono<Void> delete(@PathVariable User obj) {
        return userService.delete(obj);
    }
}
