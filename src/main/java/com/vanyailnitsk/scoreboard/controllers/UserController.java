package com.vanyailnitsk.scoreboard.controllers;

import com.vanyailnitsk.scoreboard.models.GlobalRank;
import com.vanyailnitsk.scoreboard.models.User;
import com.vanyailnitsk.scoreboard.services.UserService;
import com.vanyailnitsk.scoreboard.tasks.AlgorithmTaskResult;
import com.vanyailnitsk.scoreboard.tasks.TestResult;
import com.vanyailnitsk.scoreboard.tasks.TestTask;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("")
    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByEmail(authentication.getName());
    }

    @GetMapping("test-scores")
    public List<TestResult> getUserTestScores(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        return userService.getUserByEmail(authentication.getName()).getTestScores();
    }
    @GetMapping("global-rank")
    public GlobalRank getGlobalRank() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserRank(authentication.getName());
    }

    @GetMapping("{userId}/test-score")
    public List<TestResult> getUserTestScores(@PathVariable("userId") Integer userId) {
        return userService.getUser(userId).getTestScores();
    }

    @GetMapping("{userId}/algorithm-score")
    public List<AlgorithmTaskResult> getUserAlgorithmScores(@PathVariable("userId") Integer userId) {
        return userService.getUser(userId).getAlgorithmScores();
    }



}
