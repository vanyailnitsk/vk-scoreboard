package com.vanyailnitsk.scoreboard.services;

import com.vanyailnitsk.scoreboard.models.GlobalRank;
import com.vanyailnitsk.scoreboard.models.RegisterRequest;
import com.vanyailnitsk.scoreboard.models.Role;
import com.vanyailnitsk.scoreboard.models.User;
import com.vanyailnitsk.scoreboard.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User getUser(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("No user with id "+userId));
    }

    public User createUser(RegisterRequest request) {
        User user = new User(request.getName(),request.getEmail(),passwordEncoder.encode(request.getPassword()));
        user.setRoles(Set.of(Role.ROLE_USER));
        user.setAlgorithmScores(new ArrayList<>());
        user.setTestScores(new ArrayList<>());
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public GlobalRank getUserRank(String email) {
        GlobalRank rank = new GlobalRank();
        List<User> users = userRepository.findAll();
        users.sort((u1,u2) -> u2.getTestScores().size() - u1.getTestScores().size());
        User user = userRepository.findByEmail(email);
        rank.setTestRank(users.indexOf(user)+1);
        users.sort((u1,u2) -> u2.getAlgorithmScores().size() - u1.getAlgorithmScores().size());
        rank.setAlgorithmRank(users.indexOf(user)+1);
        users.sort((u1,u2) -> u2.getCyberSecurityScores().size() - u1.getCyberSecurityScores().size());
        rank.setCyberSecurityRank(users.indexOf(user));
        return rank;
    }


    public int getAlgorithmTaskProgress(Integer userId) {
        return userRepository.countSolvedAlgorithmTasks(userId);
    }

    public int getTestTaskProgress(Integer userId) {
        return userRepository.countSolvedTestTasks(userId);
    }


}
