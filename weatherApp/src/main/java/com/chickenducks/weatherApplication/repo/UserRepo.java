package com.chickenducks.weatherApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chickenducks.weatherApplication.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

	User findByUsername(String username);

}
