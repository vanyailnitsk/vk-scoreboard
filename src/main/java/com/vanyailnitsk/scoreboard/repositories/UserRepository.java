package com.vanyailnitsk.scoreboard.repositories;

import com.vanyailnitsk.scoreboard.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    @Query("SELECT COUNT(u) FROM AlgorithmTaskResult u WHERE u.user.userId=?1 and u.isCorrect=true ")
    int countSolvedAlgorithmTasks(Integer userId);

    @Query("SELECT COUNT(u) FROM TestResult u WHERE u.user.userId=?1 and u.score > 70")
    int countSolvedTestTasks(Integer userId);
}
