package com.chickenducks.weatherApplication.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chickenducks.weatherApplication.Model.User;


//probably won't need

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);

}
