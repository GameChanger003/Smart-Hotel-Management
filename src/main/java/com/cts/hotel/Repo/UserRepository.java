package com.cts.hotel.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.hotel.Model.Role;
import com.cts.hotel.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> { 
	Optional<User> findByEmail(String email); 

	Optional<User> findById(Long id); 

	List<User> findByRole(Role role);
}
