package com.kelwingb.myproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kelwingb.myproject.models.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
  List<Task> findByUser_Id(Long id);
  // @Query(value = "SELECT t FROM Task t WHERE t.user_id = :id", nativeQuery = )
  // List<Task> findByUser_Id(@Param("id") Long id);
}
