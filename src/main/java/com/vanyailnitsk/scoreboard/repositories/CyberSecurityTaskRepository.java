package com.vanyailnitsk.scoreboard.repositories;

import com.vanyailnitsk.scoreboard.tasks.CyberSecurityTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CyberSecurityTaskRepository extends JpaRepository<CyberSecurityTask,Integer> {
}
