package com.vanyailnitsk.scoreboard.repositories;

import com.vanyailnitsk.scoreboard.tasks.TestTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestTaskRepository extends JpaRepository<TestTask,Integer> {
}
