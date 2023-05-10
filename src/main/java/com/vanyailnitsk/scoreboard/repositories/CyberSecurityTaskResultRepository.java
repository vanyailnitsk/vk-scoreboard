package com.vanyailnitsk.scoreboard.repositories;

import com.vanyailnitsk.scoreboard.tasks.CyberSecurityTaskResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CyberSecurityTaskResultRepository extends JpaRepository<CyberSecurityTaskResult,Integer> {
}
