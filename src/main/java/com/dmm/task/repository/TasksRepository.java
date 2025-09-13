package com.dmm.task.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.config.Task;

public interface TasksRepository extends JpaRepository<Task, Integer> {

    @Query("select a from Task a where a.date between :from and :to and a.name = :name")
    List<Task> findByDateBetween(
        @Param("from") LocalDateTime from,
        @Param("to") LocalDateTime to,
        @Param("name") String name
    );
}