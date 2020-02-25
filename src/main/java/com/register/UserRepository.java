package com.register;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findById(long id);
    User findByEmail(String email);
}
