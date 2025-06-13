package com.cts.hotel.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.hotel.Model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> { // ✅ Use Long for ID
    Optional<User> findByEmail(String email); // ✅ Allows user lookup via email
    Optional<User> findById(Long id); // ✅ Find by ID
}


