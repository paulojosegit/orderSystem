package com.startup.orderSystem.controller;


import com.startup.orderSystem.domain.User;
import com.startup.orderSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

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
    @ResponseStatus(NOT_FOUND)
    public Mono<User> findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping(value = "/users")
    @ResponseStatus(CREATED)
    public Mono<User> save(@RequestBody User obj) {
        return userService.save(obj);
    }

    @PutMapping(value = "/users/{id}/UPDATE")
    public Mono<User> update(@PathVariable Integer id, @RequestBody User obj) {
        return userService.update(id, obj);
    }

    @DeleteMapping(value = "/users/{id}/DELETE")
    public Mono<Void> delete(@PathVariable Integer id) {
        return userService.deleteById(id);
    }
}
