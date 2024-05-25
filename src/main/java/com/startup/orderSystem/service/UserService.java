package com.startup.orderSystem.service;

import com.startup.orderSystem.domain.User;
import com.startup.orderSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public Mono<Void> delete(User obj) {
        return userRepository.delete(obj);
    }
}
