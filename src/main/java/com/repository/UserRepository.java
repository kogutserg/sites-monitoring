package com.repository;

import com.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserId(Long id);
    User findByEmail(String email);
}
