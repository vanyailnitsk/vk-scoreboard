package com.vanyailnitsk.scoreboard.repositories;

import com.vanyailnitsk.scoreboard.tasks.AlgorithmTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlgorithmTaskRepository extends JpaRepository<AlgorithmTask,Integer> {
    long count();
}
