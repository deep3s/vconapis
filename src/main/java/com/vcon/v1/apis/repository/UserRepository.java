package com.vcon.v1.apis.repository;

import com.vcon.v1.apis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    // You can add other custom query methods here if needed, e.g.,
    // List<User> findByRole(String role);
}
