package com.autopay.smartbillautomation.repo;

import com.autopay.smartbillautomation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Spring Data JPA automatically understands this method name
    // It will generate a query to find a user by their email
    Optional<User> findByEmail(String email);
}
