package com.startup.orderSystem.service;

import com.startup.orderSystem.domain.User;
import com.startup.orderSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Locale;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public Mono<User> save(User obj) {
        return userRepository.save(obj);
    }

    public Mono<User> update(Integer id, User obj) {
        return userRepository.findById(id)
                .flatMap(o -> {
                    o.setName(obj.getName());
                    return userRepository.save(o);
                });
    }

    public Mono<Void> deleteById(Integer id) {
        return userRepository.deleteById(id);
    }
}
