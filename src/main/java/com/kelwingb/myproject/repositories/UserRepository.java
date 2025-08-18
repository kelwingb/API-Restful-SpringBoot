package com.kelwingb.myproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kelwingb.myproject.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  
  
} 