package com.vanyailnitsk.scoreboard.repositories;

import com.vanyailnitsk.scoreboard.tasks.AlgorithmTaskResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlgorithmTaskResultRepository extends JpaRepository<AlgorithmTaskResult,Integer> {

}
