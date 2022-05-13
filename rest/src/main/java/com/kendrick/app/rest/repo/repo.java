package com.kendrick.app.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kendrick.app.rest.models.user;

public interface repo extends JpaRepository<user, Long>{

}
