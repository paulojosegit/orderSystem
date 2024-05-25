package com.startup.orderSystem.repository;

import com.startup.orderSystem.domain.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends R2dbcRepository<User, Integer> {

}
